package com.sabora.database.adapters;

import com.sabora.application.domain.Cliente;
import com.sabora.application.ports.driven.ClientRepositoryPort;
import com.sabora.database.mappers.ClientEntityMapper;
import com.sabora.database.repositories.ClienteJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ClientRepositoryPortAdapter implements ClientRepositoryPort {

    private ClienteJpaRepository clienteJpaRepository;

    private ClientEntityMapper mapper;

    @Override
    public Cliente save(Cliente cliente) {
        return mapper.toDomain(
                clienteJpaRepository.save(mapper.toEntity(cliente))
        );
    }

    @Override
    public List<Cliente> findAll() {
        return clienteJpaRepository
                .findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
