package com.sabora.api.mappers;

import com.sabora.application.domain.Scenario;
import com.sabora.application.domain.Sound;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.ScenarioDTO;

@Mapper(componentModel = "spring")
public interface ScenarioDTOMapper {

    @Mapping(target = "sound", source = "sound.name")
    ScenarioDTO toDTO(Scenario scenario);

    @Mapping(target = "sound", ignore = true)
    Scenario mapSimple(ScenarioDTO scenarioDTO);

    default Scenario toDomain(ScenarioDTO scenarioDTO) {
        if (scenarioDTO == null) {
            return null;
        }
        var scenario = mapSimple(scenarioDTO);
        scenario.setSound(Sound.builder().name(scenarioDTO.getSound()).build());
        return scenario;
    }

}
