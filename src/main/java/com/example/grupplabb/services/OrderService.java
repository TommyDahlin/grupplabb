package com.example.grupplabb.services;


import com.example.grupplabb.models.Order;
import com.example.grupplabb.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;


    //create order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    //get all existing orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    // get one order by ID
    public Order getOneOrder(String id) {
        return orderRepository.findById(id).get();
    }
    //Update orders
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }
    //Delete a order by ID
    public String deleteOrder(String id) {
        orderRepository.deleteById(id);
        return "Order deleted successfully!";
    }



}
