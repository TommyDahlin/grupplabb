package com.example.grupplabb.controllers;

import com.example.grupplabb.models.Category;
import com.example.grupplabb.models.User;
import com.example.grupplabb.repositories.CategoryRepository;
import com.example.grupplabb.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryControllers {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/find")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }
}
