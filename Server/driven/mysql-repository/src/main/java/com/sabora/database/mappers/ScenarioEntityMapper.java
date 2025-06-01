package com.sabora.database.mappers;

import com.sabora.application.domain.Scenario;
import com.sabora.database.entities.ScenarioMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SoundEntityMapper.class)
public interface ScenarioEntityMapper {
    ScenarioMO toEntity(Scenario scenario);

    Scenario toDomain(ScenarioMO scenarioMO);
}
