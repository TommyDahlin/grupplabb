package com.example.grupplabb.services;

import com.example.grupplabb.models.Category;
import com.example.grupplabb.models.User;
import com.example.grupplabb.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    // CATEGORY
    // CREATE
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    // GET ALL
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
