package com.sabora.api.mappers;

import com.sabora.api.dtos.ExperienceDTO;
import com.sabora.application.domain.Experience;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExperienceDTOMapper {

    @Mapping(target = "sounds", ignore = true)
    @Mapping(target="client", source = "client.username")
    @Mapping(target="scenario", source = "scenario.name")
    @Mapping(target="sound", source = "sound.name")
    @Mapping(target="food", source = "food.name")
    ExperienceDTO toDTO(Experience experience);

    @Mapping(target = "sounds", ignore = true)
    @Mapping(target="client", ignore = true)
    @Mapping(target="scenario", ignore = true)
    @Mapping(target="sound", ignore = true)
    @Mapping(target="food", ignore = true)
    Experience mapSimple(ExperienceDTO experienceDTO);

    default Experience toDomain(ExperienceDTO experienceDTO){
        Experience experience = mapSimple(experienceDTO);
        experience.setClient(null);
        experience.setScenario(null);
        experience.setSound(null);
        experience.setFood(null);
        return experience;
    };
}
