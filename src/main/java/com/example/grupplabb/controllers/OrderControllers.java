package com.example.grupplabb.controllers;

import com.example.grupplabb.models.Order;
import com.example.grupplabb.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OrderControllers {

@Autowired
    OrderService orderService;


    @PostMapping("/addorder")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/getallorders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    @GetMapping("/getorder/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderService.getOneOrder(id);
    }
    @PutMapping("/updateorder/{id}")
    public Order updateOrder(@RequestBody Order order, @PathVariable("id") String _id) {
        return orderService.updateOrder(order);
    }
    @DeleteMapping("/deleteorder/{id}")
    public String deleteOrder(@PathVariable String id) {
        return orderService.deleteOrder(id);
    }



    }
