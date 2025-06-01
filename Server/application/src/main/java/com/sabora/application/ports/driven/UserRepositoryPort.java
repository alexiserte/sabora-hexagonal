package com.sabora.application.ports.driven;

import com.sabora.application.domain.User;

public interface UserRepositoryPort {
    User findByUsername(String username);

    User findByDni(String dni);

    Boolean existsByUsername(String username);
}
