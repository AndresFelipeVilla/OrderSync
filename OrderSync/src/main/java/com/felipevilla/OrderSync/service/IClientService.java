package com.felipevilla.OrderSync.service;

import java.util.List;
import java.util.Optional;

import com.felipevilla.OrderSync.dto.ClientDTO;
import com.felipevilla.OrderSync.error.ClientNotFoundException;
import com.felipevilla.OrderSync.model.Client;

public interface IClientService {

    //Method to add a Client
    public Client addClient(Client client); 

    //Method to get a ClientDTO by id 
    public ClientDTO getClient(Long id) throws ClientNotFoundException;  

    //Method to get a all Clients
    public List<ClientDTO> getClients(); 

    //Method to get a Client by name
    public Optional<ClientDTO> findByNameIgnoreCase(String name) throws ClientNotFoundException;

    //Method to update a Client
    public Client updateClient(Long idClient, Client client) throws ClientNotFoundException; 

    //Method to delete a Client
    public void deleteClient(Long idClient) throws ClientNotFoundException;

    



}
