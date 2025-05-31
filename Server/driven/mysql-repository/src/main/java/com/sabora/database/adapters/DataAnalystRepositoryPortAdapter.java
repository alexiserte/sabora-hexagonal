package com.sabora.database.adapters;

import com.sabora.application.domain.DataAnalyst;
import com.sabora.application.ports.driven.DataAnalystRepositoryPort;
import com.sabora.database.mappers.DataAnalystEntityMapper;
import com.sabora.database.repositories.DataAnalystJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class DataAnalystRepositoryPortAdapter implements DataAnalystRepositoryPort {

    private DataAnalystJpaRepository dataAnalystJpaRepository;

    private DataAnalystEntityMapper mapper;

    @Override
    public DataAnalyst save(DataAnalyst dataAnalyst) {
        return mapper.toDomain(
                dataAnalystJpaRepository.save(mapper.toEntity(dataAnalyst))
        );
    }

    @Override
    public List<DataAnalyst> findAll() {
        return dataAnalystJpaRepository
                .findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
