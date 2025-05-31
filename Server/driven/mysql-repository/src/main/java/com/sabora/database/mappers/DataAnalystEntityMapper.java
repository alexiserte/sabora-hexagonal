package com.sabora.database.mappers;

import com.sabora.application.domain.Cliente;
import com.sabora.application.domain.DataAnalyst;
import com.sabora.database.entities.ClienteMO;
import com.sabora.database.entities.DataAnalystMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataAnalystEntityMapper {
    DataAnalystMO toEntity(DataAnalyst dataAnalyst);
    DataAnalyst toDomain(DataAnalystMO dataAnalystMO);
}
