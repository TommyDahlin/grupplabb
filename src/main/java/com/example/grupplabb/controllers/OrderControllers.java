package com.example.grupplabb.controllers;

import com.example.grupplabb.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class OrderControllers {

@Autowired
    OrderService orderService;

}
