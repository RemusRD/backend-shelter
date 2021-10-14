package com.example.backendshelter.controller;


import com.example.backendshelter.controller.request.CreateFoodRequest;
import com.example.backendshelter.model.Food;
import com.example.backendshelter.service.FoodService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/food")
    public void createFood(@RequestBody @Valid CreateFoodRequest request) {
        //foodService.create(request.getBrand(), request.getDescription());
    }
}
