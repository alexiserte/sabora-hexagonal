package com.sabora.server.Controllers;

import com.sabora.server.DTOs.UserDTO;
import com.sabora.server.Exceptions.User.AlreadyExistingUserException;
import com.sabora.server.Exceptions.User.IncorrectPasswordException;
import com.sabora.server.Exceptions.User.UserNotFoundException;
import com.sabora.server.Exceptions.User.UserValidationException;
import com.sabora.server.Services.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final SessionService sessionService;

    public UserController(SessionService sessionService){
        this.sessionService = sessionService;
    }


    @PostMapping("")
    @Operation(summary = "Register a new user",
            description = "This endpoint register a new user from any type. All the data has to be provided in the request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created succesfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request, invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        try {
            sessionService.register(userDTO);
            log.info("User {} created successfully", userDTO.getUsername());
            return new ResponseEntity<>("Usuario creado correctamente.", HttpStatus.CREATED);
        } catch (AlreadyExistingUserException e) {
            log.error("User {} already exists", userDTO.getUsername());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (UserValidationException e) {
            log.error("Invalid user data: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            log.error("Internal server error registering the user: {}", e.getMessage());
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {

        try {
            UserDTO user = sessionService.getUser(username, password);
            log.info("Successful login for user: {}", username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IncorrectPasswordException e) {
            log.error("Failed to login user: {} because of {}", username, e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            log.error("Internal server error getting the user: {}", e.getMessage());
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

