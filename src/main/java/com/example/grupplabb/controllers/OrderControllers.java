package com.example.grupplabb.controllers;

import com.example.grupplabb.models.Order;
import com.example.grupplabb.models.Product;
import com.example.grupplabb.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OrderControllers {

@Autowired
    private OrderService orderService;

    // POST create new order
    @PostMapping("/addorder")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // Get all orders
    @GetMapping("/getallorders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    /*public ResponseEntity<?> getAllOrders(@RequestBody Product[] products) {
        orderService.getAllOrders();
        return ResponseEntity.ok("Orders fetched successfully based on provided products");
    }*/


    // GET one order
    @GetMapping("/getorder/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderService.getOneOrder(id);
    }

    // PUT update order by ID
    @PutMapping("/updateorder/{id}")
    public Order updateOrder(@RequestBody Order order, @PathVariable("id") String _id) {
        return orderService.updateOrder(order);
    }

    // DELETE order by ID
    @DeleteMapping("/deleteorder/{id}")
    public String deleteOrder(@PathVariable String id) {
        return orderService.deleteOrder(id);
    }



    }
