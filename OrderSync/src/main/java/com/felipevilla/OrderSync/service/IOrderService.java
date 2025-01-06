package com.felipevilla.OrderSync.service;

import java.util.List;

import com.felipevilla.OrderSync.error.OrderNotFoundException;
import com.felipevilla.OrderSync.model.Order;

public interface IOrderService {

    
    //Method to add a Order 
    public Order addOrder(Order order);

    //Method to get a Order by id
    public Order getOrder(Long idOrder) throws OrderNotFoundException;

    //Method to get all Order
    public List<Order> getAllOrder();
 
    //Method to update a Order
    public Order updateOrder(Long idOrder, Order order) throws OrderNotFoundException;

    //Method to delete a Order  
    public void deleteOrder(Long idOrder) throws OrderNotFoundException;

}
