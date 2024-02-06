package com.example.grupplabb.controllers;

import com.example.grupplabb.models.Order;
import com.example.grupplabb.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderControllers {

    @Autowired
    OrderService orderService;

    // POST create new order
    @PostMapping("/add")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // Get all orders
    @GetMapping("/find")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // GET one order
    @GetMapping("/find/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderService.getOneOrder(id);
    }

    // PUT update order by ID
    @PutMapping("/update/{id}")
    public Order updateOrder(@RequestBody Order order, @PathVariable("id") String _id) {
        return orderService.updateOrder(order);
    }

    // DELETE order by ID
    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable String id) {
        return orderService.deleteOrder(id);
    }
}
