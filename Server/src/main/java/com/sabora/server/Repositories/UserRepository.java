package com.sabora.server.Repositories;

import com.sabora.server.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    User findByDni(String dni);
    User findByUsername(String username);
}

