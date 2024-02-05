package com.example.grupplabb.controllers;

import com.example.grupplabb.models.User;
import com.example.grupplabb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/user")
public class UserControllers {
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public User createBook(@RequestBody User user){
        return userService.createUser(user);
    }
    // GET ALL
    @GetMapping("/find")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    //GET ONE
    @GetMapping("/find/{id}")
    public User getUser(@PathVariable String id){
        return userService.getOneUser(id);
    }
    // UPDATE ONE
    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") String _id){
        return userService.updateUser(user);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}
