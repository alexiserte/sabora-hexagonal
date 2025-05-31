package com.sabora.database.mappers;

import com.sabora.application.domain.Sound;
import com.sabora.database.entities.SoundMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses= ExperienceSoundEntityMapper.class)
public interface SoundEntityMapper {
    SoundMO toEntity(Sound  sound);
    Sound toDomain(SoundMO soundMO);
}
