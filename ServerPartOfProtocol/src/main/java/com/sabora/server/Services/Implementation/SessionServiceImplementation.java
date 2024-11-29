package com.sabora.server.Services.Implementation;

import com.sabora.server.DTOs.UserDTO;
import com.sabora.server.Models.User;
import com.sabora.server.Services.SessionService;
import com.sabora.server.Services.UserService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SessionServiceImplementation implements SessionService {

    private final Map<String, UserService<? extends User>> userServices;

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
        if (user == null || !userServices.containsKey(userDTO.getType())) {
            throw new IllegalArgumentException("Invalid user type: " + userDTO.getType());
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
        return null;
    }


}
