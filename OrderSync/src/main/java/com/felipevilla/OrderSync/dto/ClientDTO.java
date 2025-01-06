package com.felipevilla.OrderSync.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    
    private Long idClient;
    private String name;
    private String lastName; 
    private String email;
    private String phone;
}
