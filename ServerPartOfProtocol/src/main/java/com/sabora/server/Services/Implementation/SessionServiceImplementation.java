package com.sabora.server.Services.Implementation;

import com.sabora.server.DTOs.UserDTO;
import com.sabora.server.Exceptions.IllegalUserType;
import com.sabora.server.Exceptions.UserNotFoundException;
import com.sabora.server.Models.User;
import com.sabora.server.Services.SessionService;
import com.sabora.server.Services.UserService;
import com.sabora.server.Utils.PasswordEncrypter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SessionServiceImplementation implements SessionService {

    private final Map<String, UserService<? extends User>> userServices;
    private final PasswordEncrypter passwordEncrypter = new PasswordEncrypter();

    public SessionServiceImplementation(
            GlassesUserService glassesUserService,
            FoodSpecialistService foodSpecialistService,
            ClienteService clienteService,
            DataAnalystService dataAnalystService
    ) {
        userServices = Map.of(
                "GlassesUser", glassesUserService,
                "FoodSpecialist", foodSpecialistService,
                "Cliente", clienteService,
                "DataAnalyst", dataAnalystService
        );
    }

    public void register(UserDTO userDTO) {
        User user = userDTO.toUser();
        user.setPassword(passwordEncrypter.encryptPassword(user.getPassword()));
        if (user == null || !userServices.containsKey(userDTO.getType())) {
            throw new IllegalUserType(userDTO.getType());
        }
        UserService<User> userService = (UserService<User>) userServices.get(userDTO.getType());
        userService.registerUser(user);
    }

    @Override
    public UserDTO getUser(String username) {
        for (UserService<? extends User> userService : userServices.values()) {
            User user = userService.getUser(username);
            if (user != null) {
                return new UserDTO(user);
            }
        }
        throw new UserNotFoundException(username);
    }

    @Override
    public UserDTO getUser(String username, String password) {
        for (UserService<? extends User> userService : userServices.values()) {
            User user = userService.getUser(username);
            if (user != null) {
                if (passwordEncrypter.checkPassword(password, user.getPassword())) {
                    return new UserDTO(user);
                }
                else{
                    throw new IllegalArgumentException("Invalid password");
                }
            }
        }
        throw new UserNotFoundException(username);
    }

}
