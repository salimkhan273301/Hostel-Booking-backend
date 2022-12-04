package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Categorys;
import com.example.service.CategoryService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1/")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/findallCategory")
    private List<Categorys> findCategory() {
        return categoryService.getAllCategories();
    }
    @PostMapping("/addcategory")
    private Categorys craeteCategory(Categorys category) {
		return categoryService.saveCategory(category);
    	
    }
}