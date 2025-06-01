package com.sabora.database.adapters;

import com.sabora.application.domain.Sound;
import com.sabora.application.ports.driven.SoundRepositoryPort;
import com.sabora.database.mappers.SoundEntityMapper;
import com.sabora.database.repositories.SoundJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SoundRepositoryPortAdapter implements SoundRepositoryPort {

    private SoundJpaRepository soundJpaRepository;
    private SoundEntityMapper soundEntityMapper;

    @Override
    public Sound findByName(String name) {
        return soundEntityMapper.toDomain(
                soundJpaRepository.findByName(name)
        );
    }
}
