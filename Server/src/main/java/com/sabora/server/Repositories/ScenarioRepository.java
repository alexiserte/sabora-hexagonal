package com.sabora.server.Repositories;

import com.sabora.server.Entities.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioRepository extends JpaRepository<Scenario, Integer>
{
    Scenario findByName(String name);
}
