package com.sabora.database.adapters;

import com.sabora.application.domain.GlassesUser;
import com.sabora.application.ports.driven.GlassesUserRepositoryPort;
import com.sabora.database.mappers.GlassesUserEntityMapper;
import com.sabora.database.repositories.GlassesUserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class GlassesUserRepositoryPortAdapter implements GlassesUserRepositoryPort {

    private GlassesUserJpaRepository glassesUserJpaRepository;
    private GlassesUserEntityMapper glassesUserEntityMapper;

    @Override
    public GlassesUser save(GlassesUser cliente) {
        return glassesUserEntityMapper.toDomain(
                glassesUserJpaRepository.save(glassesUserEntityMapper.toEntity(cliente))
        );
    }

    @Override
    public List<GlassesUser> findAll() {
        return glassesUserJpaRepository
                .findAll()
                .stream()
                .map(glassesUserEntityMapper::toDomain)
                .toList();
    }
}
