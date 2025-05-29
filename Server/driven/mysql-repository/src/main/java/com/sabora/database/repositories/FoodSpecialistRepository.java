package com.sabora.database.repositories;

import com.sabora.server.Entities.FoodSpecialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodSpecialistRepository  extends JpaRepository<FoodSpecialist, Long> {
}
