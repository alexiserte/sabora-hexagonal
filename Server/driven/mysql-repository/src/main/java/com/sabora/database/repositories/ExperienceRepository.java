package com.sabora.database.repositories;

import com.sabora.server.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{
    Experience findById(int id);

    List<Experience> findByClientAndScenarioAndSoundAndFood(Cliente client, Scenario scenario, Sound sound, Food food);
}
