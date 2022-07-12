package com.greenkrueger.demo.client.repos;


import com.greenkrueger.demo.client.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Client, Long> {
}