package com.example.backendshelter.controller;

import com.example.backendshelter.model.Pet;
import com.example.backendshelter.request.CreatePetFeedRQ;
import com.example.backendshelter.request.CreatePetRQ;
import com.example.backendshelter.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AdoptionController {

    private final PetService petService;

    public AdoptionController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping(value = "/pets")
    public List<Pet> getPets() {
        return petService.findAll();
    }

    @GetMapping(value = "/pet/{id}")
    public Pet getPet(@PathVariable(value = "id") Long petId) {
        return petService.findById(petId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Pet doesn't exists."));
    }

    @PostMapping(value = "/pet", consumes = "application/json")
    public List<Pet> addPet(@RequestBody @Valid List<CreatePetRQ> createPetRQ) {
        return petService.save(createPetRQ);
    }

    @PostMapping(value = "/pet-feed", consumes = "application/json")
    public Pet addPetFeed(@RequestBody @Valid CreatePetFeedRQ petFeedRQS) {
        return petService.addNewPetFeed(petFeedRQS);
    }

   /* @PostMapping(value = "/pet", consumes = "application/json")
    public List<Pet> addPet(@RequestBody @Valid List<Pet> pet) throws PetException {
        return petService.save(pet);
    }
*/
    /*//Saving several pets at the same time
    @PostMapping(value = "/pet", consumes = "application/json")
    public List<Pet> addPet(@RequestBody @Valid List<Pet> pet) throws PetException {
        return petService.save(pet);
    }*/
    /*

    @PostMapping(value = "/pet")
    public Pet createPet(@Valid @RequestBody Pet pet) throws PetException {
        return petService.save(pet);
    }
*/


}
