package com.felipevilla.OrderSync.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.felipevilla.OrderSync.error.ProductNotFoundException;
import com.felipevilla.OrderSync.model.Product;
import com.felipevilla.OrderSync.repository.ProductRepository;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;


    //Method to add a product
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    //Method to get a product by id
    @Override
    public Product getProduct(Long idProduct) throws ProductNotFoundException {
        return productRepository.findById(idProduct).orElseThrow(() -> new ProductNotFoundException("Product not found"));
          
    }
    

    //Method to get all products
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }


    //Method to search for a product with low stock
    @Override
    public Product findByStockLessThan() throws ProductNotFoundException {
        return productRepository.findByStockLessThan(10);
    }


    //Method to search for a product by name
    @Override
    public Product findByNameIgnoreCase(String name) throws ProductNotFoundException {
        return productRepository.findByNameIgnoreCase(name);
    }


    //Method to update a product
    @Override
    public Product updateProduct(Long idProduct, Product product) throws ProductNotFoundException {
        Product productToUpdate = productRepository.findById(idProduct).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setStock(product.getStock());
        productToUpdate.setCategory(product.getCategory());
        return productRepository.save(productToUpdate); 
        
    }


    //Method to delete a product
    @Override
    public void deleteProduct(Long idProduct) throws ProductNotFoundException {
        Product productToDelete = productRepository.findById(idProduct).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        productRepository.delete(productToDelete); 
    }


    
    
}
