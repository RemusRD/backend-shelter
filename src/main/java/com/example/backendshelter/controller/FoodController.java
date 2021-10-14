package com.example.backendshelter.controller;


import com.example.backendshelter.controller.request.CreateFoodRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class FoodController {

    @PostMapping("/food")
    public ResponseEntity createFood(@RequestBody CreateFoodRequest request) {
        //servicecall() -> Validate that the brand is either one of(COCO_COLA, ROYAL_CANIN, PURALINA )
        //validate that the description has a maximum size of 255
        //if any of those does not happen, return an status code of 400 and a
        //description of the field that is not correct
        //Bonus point -> return 201(CREATED) status code if the food was succesfully created.
    }
}
