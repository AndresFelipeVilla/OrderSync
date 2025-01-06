package com.felipevilla.OrderSync.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.felipevilla.OrderSync.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    //Method to get a Client by Name
    Optional<Client> findByNameIgnoreCase (String name);

    

}
