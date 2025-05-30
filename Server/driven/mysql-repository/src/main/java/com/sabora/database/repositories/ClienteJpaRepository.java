package com.sabora.database.repositories;

import com.sabora.database.entities.ClienteMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteMO, Long> {
}
