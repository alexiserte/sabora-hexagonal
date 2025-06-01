package com.sabora.api.mappers;

import com.sabora.application.domain.ConnectionParams;
import org.mapstruct.Mapper;
import org.openapitools.model.ConnectionParamsDTO;

@Mapper(componentModel = "spring")
public interface ConnectionParamsDTOMapper {
    ConnectionParamsDTO toDTO(ConnectionParams connectionParams);

    ConnectionParams toDomain(ConnectionParamsDTO connectionParamsDTO);

}
