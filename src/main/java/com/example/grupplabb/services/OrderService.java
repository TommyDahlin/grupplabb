package com.example.grupplabb.services;


import com.example.grupplabb.models.Order;
import com.example.grupplabb.models.Product;
import com.example.grupplabb.models.User;
import com.example.grupplabb.repositories.OrderRepository;
import com.example.grupplabb.repositories.ProductRepository;
import com.example.grupplabb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;


    //create order
    public Order createOrder(Order order) {
        List<User> allUsers = userRepository.findAll();
        User foundUser = null;
        for (User user : allUsers) {
            if (user.getId().equals(order.getUserId())) {
                foundUser = user;
            }
        }
        List<Product> allProducts = productRepository.findAll();
        List<Product> foundProducts = new ArrayList<>();
        int fullPrice = 0;
        int takePrice = 0;
        for (Product product : allProducts) {
            for (String productId : order.getProductId()) {
                if (product.getId().equals(productId)) {
                    takePrice = product.getPrice();
                    fullPrice = takePrice + fullPrice;
                    foundProducts.add(product);
                    order.setTotalPrice(fullPrice);
                }
            }
        }
        if (foundUser == null || foundProducts.isEmpty()) {
            throw new RuntimeException("User or products must exist!");
        }
        order.setUser(foundUser);
        order.setProduct(foundProducts);
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
