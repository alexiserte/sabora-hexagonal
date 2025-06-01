package com.sabora.database.repositories;

import com.sabora.database.entities.UserMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserMO, Long> {
    boolean existsByUsername(String username);

    UserMO findByDni(String dni);

    UserMO findByUsername(String username);
}

