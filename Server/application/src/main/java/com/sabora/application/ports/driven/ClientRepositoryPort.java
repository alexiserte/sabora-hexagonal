package com.sabora.application.ports.driven;

import com.sabora.application.domain.Cliente;

import java.util.List;

public interface ClientRepositoryPort {
    Cliente save(Cliente cliente);

    List<Cliente> findAll();
}
