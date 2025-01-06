package com.felipevilla.OrderSync.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.felipevilla.OrderSync.dto.ClientDTO;
import com.felipevilla.OrderSync.error.ClientNotFoundException;
import com.felipevilla.OrderSync.model.Client;
import com.felipevilla.OrderSync.service.IClientService;


import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/Clients")
public class ClientController {


    @Autowired
    private IClientService clientService;

    //Method to add a Client
    @PostMapping("/addClient")
    public Client addClient(@Valid @RequestBody Client client) {
        return clientService.addClient(client);
    }


    //Method to get a Client
    @GetMapping("/getClient/{idClient}")
    public ClientDTO getClient (@PathVariable Long idClient) throws ClientNotFoundException{
       return clientService.getClient(idClient);
    }

    
    //Method to get all Clients
    @GetMapping("/getClients")
    public List<ClientDTO> getClients() {
        return clientService.getClients();
    }


    //Method to get a Client by name
    @GetMapping("/getClientByName/{name}")
    public Optional<ClientDTO> findByName(@PathVariable String name) throws ClientNotFoundException {
        return clientService.findByNameIgnoreCase(name);  
    }

    
    //Method to update a Client
    @PutMapping("/updateClient/{idClient}")
    public Client updateClient(@PathVariable Long idClient, @Valid @RequestBody Client client) throws ClientNotFoundException {
        return clientService.updateClient(idClient, client); 
    }

    
    //Method to delete a Client 
    @DeleteMapping("/deleteClient/{idClient}")
    public ResponseEntity<String> deleteClient(@PathVariable Long idClient) throws ClientNotFoundException {
        clientService.deleteClient(idClient); 
        return ResponseEntity.ok("Client deleted"); 
    }


    
    

    
    

}
