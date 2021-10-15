package com.example.backendshelter.service;

import com.example.backendshelter.model.Brand;
import com.example.backendshelter.model.Food;
import com.example.backendshelter.repository.FoodRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    public void save(Brand brand, String description) {
        foodRepository.save(Food.builder().brand(brand).description(description).build());
    }
}
