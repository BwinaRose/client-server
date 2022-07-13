package com.greenkrueger.demo.client.services;


import com.greenkrueger.demo.client.exceptions.ClientCreationException;
import com.greenkrueger.demo.client.models.Client;
import com.greenkrueger.demo.client.repos.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    private ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public Client create(Client client) throws ClientCreationException {
        return clientRepo.save(client);
    }

    @Override
    public Client getById(long id) throws ClientCreationException {
        Optional<Client> optional = clientRepo.findById(id);
        if (optional.isEmpty())
            throw new ClientCreationException(String.format("Client with id {} not found", id));
        return optional.get();
    }

    @Override
    public Iterable<Client> getAllClients(){
        return clientRepo.findAll();
    }
}