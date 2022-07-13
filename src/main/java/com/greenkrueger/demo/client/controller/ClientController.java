package com.greenkrueger.demo.client.controller;

import com.greenkrueger.demo.client.exceptions.ClientCreationException;
import com.greenkrueger.demo.client.models.Client;
import com.greenkrueger.demo.client.services.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private ClientService clientService;

    @GetMapping("/client")
    public Iterable<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping("/client")
    public Client getAllClients(@RequestBody Client client) throws ClientCreationException{
        return clientService.create(client);
    }
}
