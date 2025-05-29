package com.sabora.application.services;

import com.sabora.server.Entities.GlassesUser;
import com.sabora.server.Repositories.GlassesUserRepository;
import com.sabora.server.Services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlassesUserService  implements UserService<GlassesUser> {

    private GlassesUserRepository glassesUserRepository;

    public GlassesUserService(GlassesUserRepository glassesUserRepository){
        this.glassesUserRepository = glassesUserRepository;
    }

    @Override
    public void registerUser(GlassesUser user) {
        glassesUserRepository.save(user);
    }

    @Override
    public GlassesUser getUser(String username) {
        List<GlassesUser> users = glassesUserRepository.findAll();
        for (GlassesUser user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
