package com.sabora.server.Controllers;

import com.sabora.server.DTOs.UserDTO;
import com.sabora.server.Models.User;
import com.sabora.server.Services.Implementation.SessionServiceImplementation;
import com.sabora.server.Services.SessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final SessionService sessionService;

    public UserController(SessionService sessionService){
        this.sessionService = sessionService;
    }


    @PostMapping("")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        sessionService.register(userDTO);
        return new ResponseEntity<>("Usuario creado correctamente.",HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username) {
        UserDTO user = sessionService.getUser(username);
        if (user == null) {
            return new ResponseEntity<>("Usuario no encontrado.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
