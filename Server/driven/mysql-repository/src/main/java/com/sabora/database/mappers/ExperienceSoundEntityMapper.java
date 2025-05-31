package com.sabora.database.mappers;

import com.sabora.application.domain.ExperienceSound;
import com.sabora.database.entities.ExperienceSoundMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienceSoundEntityMapper {
    ExperienceSound toDomain(ExperienceSoundMO experienceSoundEntity);
    ExperienceSoundMO toEntity(ExperienceSound experienceSound);
}
