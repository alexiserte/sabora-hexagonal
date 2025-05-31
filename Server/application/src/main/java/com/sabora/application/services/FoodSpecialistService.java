package com.sabora.application.services;

import com.sabora.application.domain.FoodSpecialist;
import com.sabora.application.ports.driven.FoodSpecialistRepositoryPort;
import com.sabora.application.ports.driving.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoodSpecialistService implements UserService<FoodSpecialist> {

    private FoodSpecialistRepositoryPort foodSpecialistRepository;


    @Override
    public void registerUser(FoodSpecialist user) {
        foodSpecialistRepository.save(user);
    }

    @Override
    public FoodSpecialist getUser(String username) {
        List<FoodSpecialist> users = foodSpecialistRepository.findAll();
        for (FoodSpecialist user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

}
