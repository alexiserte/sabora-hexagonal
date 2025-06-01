package com.sabora.database.repositories;

import com.sabora.database.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceJpaRepository extends JpaRepository<ExperienceMO, Integer> {
    ExperienceMO findById(int id);

    List<ExperienceMO> findByClientAndScenarioAndSoundAndFood(ClienteMO client, ScenarioMO scenario, SoundMO sound, FoodMO food);
}
