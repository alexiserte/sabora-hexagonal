package com.sabora.database.mappers;

import com.sabora.application.domain.Cliente;
import com.sabora.database.entities.ClienteMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {
    ClienteMO toEntity(Cliente cliente);

    Cliente toDomain(ClienteMO clienteMO);
}
