package com.greenkrueger.demo.client.controller;

import com.greenkrueger.demo.client.exceptions.ClientCreationException;
import com.greenkrueger.demo.client.exceptions.ClientNotFoundException;
import com.greenkrueger.demo.client.models.Client;
import com.greenkrueger.demo.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client")
    public Iterable<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping("/client")
    public Client getAllClients(@RequestBody Client client) throws ClientCreationException{
        return clientService.create(client);
    }

    @GetMapping("/client/{id}")
    public Client getById(@PathVariable("id") Long id) throws ClientNotFoundException{
        return clientService.getClientById(id);
    }
}
