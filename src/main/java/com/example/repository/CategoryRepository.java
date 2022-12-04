package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.model.Categorys;

import java.util.List;



@Repository
public interface CategoryRepository extends CrudRepository<Categorys, Long> {

    Categorys getCategoryByCategoryName(String name);

    List<Categorys> findAll();
}