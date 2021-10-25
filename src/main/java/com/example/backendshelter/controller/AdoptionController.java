package com.example.backendshelter.controller;

import com.example.backendshelter.controller.request.CreatePetFeedRequest;
import com.example.backendshelter.controller.request.CreatePetRequest;
import com.example.backendshelter.controller.request.UpdatePetNameRequest;
import com.example.backendshelter.controller.response.FactResponse;
import com.example.backendshelter.controller.response.PetResponse;
import com.example.backendshelter.model.Pet;
import com.example.backendshelter.service.FactService;
import com.example.backendshelter.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
public class AdoptionController {

    private final PetService petService;
    private final FactService factService;

    @GetMapping(value = "/pets")
    public List<Pet> getPets() {
        return petService.findAll();
    }

    @GetMapping(value = "/pets/{id}")
    public Pet getPet(@PathVariable(value = "id") Long petId) {
        return petService.findById(petId);
    }

    @PutMapping("/pets/{id}/name")
    public ResponseEntity<PetResponse> updatePetName(@PathVariable Long id, @RequestBody UpdatePetNameRequest request) {
        final Pet updatedPet = petService.updateName(id, request.getName());
        final var responseBody = new PetResponse(updatedPet.getId(), updatedPet.getPetType(), updatedPet.getName());
        return ResponseEntity.ok(responseBody);
    }


    @PostMapping(value = "/pets", consumes = "application/json")
    public List<Pet> addPet(@RequestBody @Valid List<CreatePetRequest> createPetRQ) {
        return petService.save(createPetRQ);
    }

    @GetMapping(value = "/pets/cats/fact")
    public ResponseEntity<FactResponse> getCatFact() {
        final var fact = factService.getFact();
        return ResponseEntity.ok(new FactResponse(fact));
    }

    @PostMapping(value = "/pets/feed", consumes = "application/json")
    public Pet addPetFeed(@RequestBody @Valid CreatePetFeedRequest petFeedRQS) {
        return petService.addNewPetFeed(petFeedRQS);
    }


}
