package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Feature;
import com.example.repository.FeaturesRepository;

@Service
public class FeaturesService {
    private final FeaturesRepository featuresRepository;
    @Autowired
    public FeaturesService(FeaturesRepository featuresRepository) {
        this.featuresRepository = featuresRepository;
    }

    public List<Feature> findedAllFeatures() {
        return featuresRepository.findAll();
    }

	public Feature saveFeature(Feature feature) {
		
		return featuresRepository.save(feature);
	}

	public String removeFeature(long id) {
	
		  featuresRepository.deleteById(id);
		  return "deleted sucsessfully";
	}
}