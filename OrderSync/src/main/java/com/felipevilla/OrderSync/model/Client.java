package com.felipevilla.OrderSync.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idClient;
    @NotBlank(message = "Please add the name")
    private String name;
    private String lastName; 
    @NotBlank(message = "Email is required")
    @Email(message = "Please add a valid email") 
    private String email;
    private String phone;
    private String address; 

    //Relationships
    @OneToMany(mappedBy = "client")
    @JsonManagedReference
    private List<Order> orders;   

}
