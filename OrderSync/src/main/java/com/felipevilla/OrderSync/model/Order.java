package com.felipevilla.OrderSync.model;

import java.time.LocalDate;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idOrder; 
    private LocalDate date; 
    private Double total; 


    //Method to calculate the total of the order
    public double calculateTotal() {
        this.total = listProducts.stream()
            .filter(product -> product != null && product.getPrice() != null) // Avoid null products 
            .mapToDouble(Product::getPrice) // Obtend the price of each product
            .sum(); 
        return this.total; 
    }
    
    
    
    
    //Relationships
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonBackReference
    private Client client;   
    
    @ManyToMany
    @JoinTable(
    name = "order_product", // Name the table that will store the relationship
    joinColumns = @JoinColumn(name = "id_order"), // Foreign key to the table `orders`
    inverseJoinColumns = @JoinColumn(name = "id_product") // Fore
    )
    private List<Product> listProducts;




}
