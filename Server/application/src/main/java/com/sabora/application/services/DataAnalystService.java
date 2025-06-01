package com.sabora.application.services;

import com.sabora.application.domain.DataAnalyst;
import com.sabora.application.ports.driven.DataAnalystRepositoryPort;
import com.sabora.application.ports.driving.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DataAnalystService implements UserService<DataAnalyst> {

    private DataAnalystRepositoryPort dataAnalystRepository;


    @Override
    public void registerUser(DataAnalyst user) {
        dataAnalystRepository.save(user);
    }

    @Override
    public DataAnalyst getUser(String username) {
        List<DataAnalyst> users = dataAnalystRepository.findAll();
        for (DataAnalyst user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
