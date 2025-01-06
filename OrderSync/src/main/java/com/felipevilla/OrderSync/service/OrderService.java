package com.felipevilla.OrderSync.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipevilla.OrderSync.error.OrderNotFoundException;
import com.felipevilla.OrderSync.model.Order;
import com.felipevilla.OrderSync.repository.OrderRepository;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;


    //Method to add a Order
    @Override
    public Order addOrder(Order order) {
        if (order.getListProducts() == null || order.getListProducts().isEmpty()) {
            throw new IllegalArgumentException("The order must have at least one product.");
        }
        order.calculateTotal(); // Update the total of the order
        return orderRepository.save(order);
    }
    


    //Method to get a Order
    @Override
    public Order getOrder(Long idOrder) throws OrderNotFoundException{
        return orderRepository.findById(idOrder).orElseThrow(() -> new OrderNotFoundException("Order not found")); 
        
    }


    //Method to get all Order
    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }


    //Method to update a Order
    @Override
    public Order updateOrder(Long idOrder, Order order) throws OrderNotFoundException {
        Order orderToUpdate = orderRepository.findById(idOrder).orElseThrow(() -> new OrderNotFoundException("Order not found"));
        orderToUpdate.setDate(order.getDate());
        orderToUpdate.setListProducts(order.getListProducts());
        orderToUpdate.calculateTotal(); // Recalculate the total of the order
        return orderRepository.save(orderToUpdate);
    }


    //Method to delete a Order
    @Override
    public void deleteOrder(Long idOrder) throws OrderNotFoundException {
        Order orderdelete = orderRepository.findById(idOrder).orElseThrow(() -> new OrderNotFoundException("Order not found"));
        orderRepository.delete(orderdelete);
    }


}
