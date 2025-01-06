package com.felipevilla.OrderSync.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.felipevilla.OrderSync.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
    
    //Method to search for a product with low stock. 
    Product findByStockLessThan(int stock); 


    //Method to search for a product by name
    <Optional> Product findByNameIgnoreCase (String name);  


    //Method to search for a product by category
    <Optional> Product findByCategoryIgnoreCase (String category);
}
