package com.felipevilla.OrderSync.service;

import java.util.List;


import com.felipevilla.OrderSync.error.ProductNotFoundException;
import com.felipevilla.OrderSync.model.Product;

public interface IProductService {

    //Method to add a product
    public Product addProduct(Product product);


    //Method to get all products
    public List<Product> getProducts();


    //Method to get a product by id
    public Product getProduct(Long id) throws ProductNotFoundException;


    //Method to search for a product with low stock
    public Product findByStockLessThan() throws ProductNotFoundException; 


    //Method to search for a product by name
    public Product findByNameIgnoreCase(String name) throws ProductNotFoundException;


    //Method to update a product
    public Product updateProduct(Long idProduct, Product product) throws ProductNotFoundException;


    //Method to delete a product
    public void deleteProduct(Long idProduct) throws ProductNotFoundException;


    
    
    
    
}
