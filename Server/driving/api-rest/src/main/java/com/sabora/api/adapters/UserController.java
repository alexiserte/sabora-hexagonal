package com.sabora.api.adapters;

import com.sabora.api.mappers.UserDTOMapper;
import com.sabora.application.exception.User.AlreadyExistingUserException;
import com.sabora.application.exception.User.IncorrectPasswordException;
import com.sabora.application.exception.User.UserNotFoundException;
import com.sabora.application.exception.User.UserValidationException;
import com.sabora.application.ports.driving.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.UserApi;
import org.openapitools.model.SimpleMessageDTO;
import org.openapitools.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController implements UserApi {

    private final SessionService sessionService;
    private final UserDTOMapper userDTOMapper;

    @Override
    public ResponseEntity<SimpleMessageDTO> register(UserDTO userDTO) {
        sessionService.register(userDTOMapper.toUser(userDTO));
        log.info("User {} created successfully", userDTO.getUsername());
        return new ResponseEntity<>(new SimpleMessageDTO("User created successfully"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDTO> getUser(String username, String password) {
        UserDTO user = userDTOMapper.toDTO(sessionService.getUser(username, password));
        log.info("Successful login for user: {}", username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

