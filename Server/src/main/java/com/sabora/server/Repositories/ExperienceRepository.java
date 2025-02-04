package com.sabora.server.Repositories;

import com.sabora.server.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{
    Experience findById(int id);

    Experience findByClientAndScenarioAndSoundAndFood(Cliente client, Scenario scenario, Sound sound, Food food);
}
