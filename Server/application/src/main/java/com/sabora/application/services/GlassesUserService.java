package com.sabora.application.services;

import com.sabora.application.domain.GlassesUser;
import com.sabora.application.ports.driven.GlassesUserRepositoryPort;
import com.sabora.application.ports.driving.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GlassesUserService  implements UserService<GlassesUser> {

    private GlassesUserRepositoryPort glassesUserRepository;


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
