package com.sabora.database.repositories;

import com.sabora.database.entities.FormMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormJpaRepository extends JpaRepository<FormMO, Long> {
    FormMO findByName(String name);
}
