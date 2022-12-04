package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Feature;

import java.util.List;


@Repository
public interface FeaturesRepository extends CrudRepository<Feature, Long> {
    List<Feature> findAll();
}