package com.example.grupplabb.services;

import com.example.grupplabb.models.User;
import com.example.grupplabb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    // USER
    // CREATE
    public User createUser(User user){
        return userRepository.save(user);
    }
    // READ
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    // READ 1
    public User getOneUser(String id){
        return userRepository.findById(id).get();
    }
    // PUT
    public User updateUser(User user){
        return userRepository.save(user);
    }
    // DELETE 1
    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "Deleted successfully!";
    }
}
