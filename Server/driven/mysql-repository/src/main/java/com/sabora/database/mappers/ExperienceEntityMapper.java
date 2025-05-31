package com.sabora.database.mappers;

import com.sabora.application.domain.Experience;
import com.sabora.database.entities.ExperienceMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
uses = {
    ClientEntityMapper.class,
        ScenarioEntityMapper.class,
        SoundEntityMapper.class,
        FoodEntityMapper.class,
        ExperienceSoundEntityMapper.class
})
public interface ExperienceEntityMapper {
    ExperienceMO toEntity(Experience experience);
    Experience toDomain(ExperienceMO experienceMO);
}
