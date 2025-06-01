package com.sabora.application.ports.driven;

import com.sabora.application.domain.DataAnalyst;

import java.util.List;

public interface DataAnalystRepositoryPort {
    DataAnalyst save(DataAnalyst cliente);

    List<DataAnalyst> findAll();
}
