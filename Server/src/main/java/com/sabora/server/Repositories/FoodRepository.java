package com.sabora.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sabora.server.Entities.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByName(String name);
}
