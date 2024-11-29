package com.sabora.server.Services;

import com.sabora.server.Models.GlassesUser;
import com.sabora.server.Models.User;
import com.sabora.server.Repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final GlassesUserRepository glassesUserRepository;
    private final DataAnalystRepository dataAnalystRepository;
    private final FoodSpecialistRepository foodSpecialistRepository;
    private final ClienteRepository clienteRepository;

    public UserService(UserRepository userRepository, GlassesUserRepository glassesUserRepository, DataAnalystRepository dataAnalystRepository, FoodSpecialistRepository foodSpecialistRepository, ClienteRepository clienteRepository) {
        this.userRepository = userRepository;
        this.glassesUserRepository = glassesUserRepository;
        this.dataAnalystRepository = dataAnalystRepository;
        this.foodSpecialistRepository = foodSpecialistRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void registerGlassesUser(GlassesUser glassesUser) {
        glassesUserRepository.save(glassesUser);

    }

}
