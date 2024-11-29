package com.sabora.server.Controllers;

import com.sabora.server.DTOs.UserDTO;
import com.sabora.server.Models.User;
import com.sabora.server.Services.Implementation.SessionServiceImplementation;
import com.sabora.server.Services.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    private final SessionService sessionService;

    public UserController(SessionService sessionService){
        this.sessionService = sessionService;
    }


    @PostMapping("")
    @Operation(summary = "Register a new user",
            description = "This endpoint register a new user from any type. All the data has to be provided in the request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created succesfully",
                    content = @io.swagger.v3.oas.annotations.media.Content(examples = {
                            @ExampleObject(name = "User created succesfully", value = "Usuario creado correctamente.")
                    }),
                    headers = {}),
            @ApiResponse(responseCode = "400", description = "Bad Request, invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        sessionService.register(userDTO);
        return new ResponseEntity<>("Usuario creado correctamente.",HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getUser(@RequestBody HashMap<String,String> body) {
        String username = body.get("username");
        String password = body.get("password");
        UserDTO user = sessionService.getUser(username,password);
        try{
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>("Error: "+e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
