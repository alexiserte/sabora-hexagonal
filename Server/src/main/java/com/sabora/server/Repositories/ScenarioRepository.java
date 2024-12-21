package com.sabora.server.Repositories;

import com.sabora.server.Models.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScenarioRepository extends JpaRepository<Scenario, Integer>
{
}
