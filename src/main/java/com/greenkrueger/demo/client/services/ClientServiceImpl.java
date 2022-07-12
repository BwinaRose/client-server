package com.greenkrueger.demo.client.services;


import com.greenkrueger.demo.client.exceptions.ClientCreationException;
import com.greenkrueger.demo.client.models.Client;
import com.greenkrueger.demo.client.repos.ClientRepo;
import org.springframework.stereotype.Service;

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
}