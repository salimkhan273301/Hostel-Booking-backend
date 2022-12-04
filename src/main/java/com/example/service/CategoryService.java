package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Categorys;
import com.example.repository.CategoryRepository;



@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Categorys> getAllCategories() {
        return categoryRepository.findAll();
    }

	public Categorys saveCategory(Categorys category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}
}
