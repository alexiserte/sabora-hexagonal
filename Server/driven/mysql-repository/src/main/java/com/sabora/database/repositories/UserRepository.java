package com.sabora.database.repositories;

import com.sabora.server.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    User findByDni(String dni);
    User findByUsername(String username);
}

