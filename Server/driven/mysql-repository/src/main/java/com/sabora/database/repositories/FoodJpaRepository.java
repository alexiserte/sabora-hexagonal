package com.sabora.database.repositories;

import com.sabora.database.entities.FoodMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodJpaRepository extends JpaRepository<FoodMO, Long> {
    FoodMO findByName(String name);
}
