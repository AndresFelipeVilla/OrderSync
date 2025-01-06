package com.felipevilla.OrderSync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipevilla.OrderSync.error.ProductNotFoundException;
import com.felipevilla.OrderSync.model.Product;
import com.felipevilla.OrderSync.service.IProductService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/Products")
public class ProductController {

    @Autowired
    private IProductService productService;


    //Method to add a product
    @PostMapping("/product")
    public Product addProduct(@Valid @RequestBody Product product) {
        return productService.addProduct(product);
    }


    //Method to get all products 
    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    

    //Method to get a product by id
    @GetMapping("/getProduct/{idProduct}")
    public Product geProduct(@PathVariable Long idProduct) throws ProductNotFoundException {
        return productService.getProduct(idProduct);
    }
    

    //Method to search for a product with low stock
    @GetMapping("/findByStockLessThan")
    public Product findByStockLessThan() throws ProductNotFoundException {
        return productService.findByStockLessThan();
    }
    

    //Method to search for a product by name
    @GetMapping("/findByNameIgnoreCase/{name}")
    public Product findByNameIgnoreCase(@PathVariable String name) throws ProductNotFoundException {
        return productService.findByNameIgnoreCase(name);
    }


    //Method to update a product
    @PutMapping("/updateProduct/{idProduct}")
    public Product updateProduct(@PathVariable Long idProduct, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(idProduct, product);
    }


    //Method to delete a product
    @DeleteMapping("/deleteProduct/{idProduct}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long idProduct) throws ProductNotFoundException {
        productService.deleteProduct(idProduct);
        return ResponseEntity.ok("Product deleted");

    }


    


    
}
