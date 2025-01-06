package com.felipevilla.OrderSync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.felipevilla.OrderSync.error.OrderNotFoundException;
import com.felipevilla.OrderSync.model.Order;
import com.felipevilla.OrderSync.service.IOrderService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("Order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    //Method to add a Order
    @PostMapping("/addOrder")
    public Order addOrder (@RequestBody Order order){
        return orderService.addOrder(order);
    }
    

    //Method to get a Order
    @GetMapping("/getOrder/{idOrder}")
    public Order getOrder (@PathVariable Long idOrder) throws OrderNotFoundException{
        return orderService.getOrder(idOrder);
    }


    //Method to get all Order
    @GetMapping("/getAllOrder")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }


    //Method to update a Order
    @PutMapping("/updateOrder/{idOrder}")
    public Order updateOrder(@PathVariable Long idOrder, @RequestBody Order order) throws OrderNotFoundException{
        return orderService.updateOrder(idOrder, order);
    }

    
    //Method to delete a Order
    @DeleteMapping("/deleteOrder/{idOrder}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long idOrder) throws OrderNotFoundException{
        orderService.deleteOrder(idOrder) ;
        return ResponseEntity.ok("Order deleted");
    }


}
