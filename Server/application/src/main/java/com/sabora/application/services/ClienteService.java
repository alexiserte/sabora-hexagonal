package com.sabora.application.services;

import com.sabora.application.domain.Cliente;
import com.sabora.application.exception.User.UserValidationException;
import com.sabora.application.ports.driven.ClientRepositoryPort;
import com.sabora.application.ports.driving.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService implements UserService<Cliente> {

    private ClientRepositoryPort clienteRepository;

    @Override
    public void registerUser(Cliente user) {
        clienteRepository.save(user);
    }

    @Override
    public Cliente getUser(String username) {
        List<Cliente> users = clienteRepository.findAll();
        for (Cliente user : users) {
            if (username.equals(user.getUsername())) return user;
        }
        throw  new UserValidationException(username);
    }
}
