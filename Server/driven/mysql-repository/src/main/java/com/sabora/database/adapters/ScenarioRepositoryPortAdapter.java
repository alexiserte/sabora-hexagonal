package com.sabora.database.adapters;

import com.sabora.application.domain.Scenario;
import com.sabora.application.ports.driven.ScenarioRepositoryPort;
import com.sabora.database.mappers.ScenarioEntityMapper;
import com.sabora.database.repositories.ScenarioJpaRepository;

public class ScenarioRepositoryPortAdapter implements ScenarioRepositoryPort {

    private ScenarioJpaRepository scenarioJpaRepository;
    private ScenarioEntityMapper scenarioEntityMapper;

    @Override
    public Scenario findByName(String name) {
        return scenarioEntityMapper
                .toDomain(scenarioJpaRepository.findByName(name));
    }

    @Override
    public Scenario save(Scenario scenario) {
        return scenarioEntityMapper
                .toDomain(scenarioJpaRepository.save(scenarioEntityMapper.toEntity(scenario)));
    }
}
