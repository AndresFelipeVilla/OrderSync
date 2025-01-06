package com.felipevilla.OrderSync.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipevilla.OrderSync.dto.ClientDTO;
import com.felipevilla.OrderSync.error.ClientNotFoundException;
import com.felipevilla.OrderSync.model.Client;
import com.felipevilla.OrderSync.repository.ClientRepository;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    
    //Method to add a client 
    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client); 
    }



    //Method to get a client by id  
    @Override
    public ClientDTO getClient(Long idClient) throws ClientNotFoundException {  
    // Obtain entity and map to DTO
        Client client = clientRepository.findById(idClient).orElseThrow(() -> new ClientNotFoundException("Client not found"));
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setIdClient(client.getIdClient());
        clientDTO.setName(client.getName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setPhone(client.getPhone());
        return clientDTO;
    }
 


    //Method to get all clients
    @Override
    public List<ClientDTO> getClients() {
        // Obtain all entities from the repository
        List<Client> clients = clientRepository.findAll();

        // Trandform the entities to DTOs
         return clients.stream()
        .map(client -> mapToClientDTO(client))
        .collect(Collectors.toList());
    }
        // Method to map a Client entity to a ClientDTO
        private ClientDTO mapToClientDTO(Client client) {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setIdClient(client.getIdClient());
            clientDTO.setName(client.getName());
            clientDTO.setLastName(client.getLastName());
            clientDTO.setEmail(client.getEmail());
            clientDTO.setPhone(client.getPhone());
            return clientDTO;
    }


    //Method to get a client by name
    @Override
    public Optional<ClientDTO> findByNameIgnoreCase(String name) throws ClientNotFoundException {       
    
        // Consult directly in the repository using a Spring Data JPA derived method
        Optional<Client> clientOptional = clientRepository.findByNameIgnoreCase(name); 

        // Transform the entity to DTO if the client is found
        return clientOptional.map(client -> {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setIdClient(client.getIdClient());
        clientDTO.setName(client.getName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setPhone(client.getPhone());
        return clientDTO;
    });
    }


    //Method to update a client
    @Override
    public Client updateClient(Long idClient, Client client) throws ClientNotFoundException {
        Client  clientToUpdate = clientRepository.findById(idClient).orElseThrow(() -> new ClientNotFoundException("Client not found"));
        clientToUpdate.setName(client.getName());
        clientToUpdate.setLastName(client.getLastName());
        clientToUpdate.setEmail(client.getEmail());
        clientToUpdate.setPhone(client.getPhone());
        return clientRepository.save(clientToUpdate);
    }


    //Method to delete a clinet
    @Override
    public void deleteClient(Long idClient) throws ClientNotFoundException {
        Client clientToDelete = clientRepository.findById(idClient).orElseThrow(() -> new ClientNotFoundException("Client not found"));
        clientRepository.delete(clientToDelete);
    }

    
    



    


    

    

}
