package com.sabora.database.adapters;

import com.sabora.application.domain.User;
import com.sabora.application.ports.driven.UserRepositoryPort;
import com.sabora.database.repositories.UserEntityMapper;
import com.sabora.database.repositories.UserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepositoryPortAdapter implements UserRepositoryPort {

    private UserJpaRepository userJpaRepository;
    private UserEntityMapper userEntityMapper;

    @Override
    public User findByUsername(String username) {
        return userEntityMapper
                .toDomain(userJpaRepository.findByUsername(username));
    }

    @Override
    public User findByDni(String dni) {
        return userEntityMapper
                .toDomain(userJpaRepository.findByDni(dni));
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userJpaRepository.existsByUsername(username);
    }
}
