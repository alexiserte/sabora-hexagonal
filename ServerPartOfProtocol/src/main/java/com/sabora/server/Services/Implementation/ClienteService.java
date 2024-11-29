package com.sabora.server.Services.Implementation;

import com.sabora.server.Models.Cliente;
import com.sabora.server.Repositories.ClienteRepository;
import com.sabora.server.Services.UserService;

import java.util.List;

public class ClienteService implements UserService<Cliente> {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void registerUser(Cliente user) {
        clienteRepository.save(user);
    }

    @Override
    public Cliente getUser(String username) {
        List<Cliente> users = clienteRepository.findAll();
        for (Cliente user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
