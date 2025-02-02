package com.sabora.server.Services.Implementation;

import com.sabora.server.Entities.DataAnalyst;
import com.sabora.server.Repositories.DataAnalystRepository;
import com.sabora.server.Services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataAnalystService implements UserService<DataAnalyst> {

    private DataAnalystRepository dataAnalystRepository;

    public DataAnalystService(DataAnalystRepository dataAnalystRepository){
        this.dataAnalystRepository = dataAnalystRepository;
    }

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
