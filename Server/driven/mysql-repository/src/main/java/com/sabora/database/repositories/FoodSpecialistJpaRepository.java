package com.sabora.database.repositories;

import com.sabora.database.entities.FoodSpecialistMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodSpecialistJpaRepository extends JpaRepository<FoodSpecialistMO, Long> {
}
