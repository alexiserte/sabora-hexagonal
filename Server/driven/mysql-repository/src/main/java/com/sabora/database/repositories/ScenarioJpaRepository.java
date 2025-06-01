package com.sabora.database.repositories;

import com.sabora.database.entities.ScenarioMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioJpaRepository extends JpaRepository<ScenarioMO, Integer>
{
    ScenarioMO findByName(String name);
}
