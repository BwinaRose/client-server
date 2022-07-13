package com.greenkrueger.demo.client.services;

import com.greenkrueger.demo.client.exceptions.ClientCreationException;
import com.greenkrueger.demo.client.exceptions.ClientNotFoundException;
import com.greenkrueger.demo.client.models.Client;

public interface ClientService {
    Client create(Client client) throws ClientCreationException;
    Client getClientById(long id) throws ClientNotFoundException;
    Iterable<Client> getAllClients();
}