package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.model.Feature;
import com.example.service.FeaturesService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1/")
public class FeaturesController {
    private final FeaturesService featuresService;

    @Autowired
    public FeaturesController(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }

    @RequestMapping("/features")
    private List<Feature> findedAllFeatures() {
        return featuresService.findedAllFeatures();
    }
    @PostMapping("/features")
    private Feature createFeature(@RequestBody Feature feature) {
		return featuresService.saveFeature(feature);
    	
    }
    @DeleteMapping("/features/{id}")
    private String DeleteFeature(@PathVariable("id") long id ) {
    	long id1=Long.valueOf(id);
    	featuresService.removeFeature(id1);
    	return "send data to feature service";
    }
    
}