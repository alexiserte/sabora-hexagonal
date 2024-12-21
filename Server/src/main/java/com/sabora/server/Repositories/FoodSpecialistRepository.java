package com.sabora.server.Repositories;

import com.sabora.server.Models.FoodSpecialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodSpecialistRepository  extends JpaRepository<FoodSpecialist, Long> {
}
