package com.example.backendshelter.service;

import com.example.backendshelter.exception.PetNotFound;
import com.example.backendshelter.model.Pet;
import com.example.backendshelter.repository.PetRepository;
import com.example.backendshelter.controller.request.CreatePetFeedRQ;
import com.example.backendshelter.controller.request.CreatePetRQ;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;


    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }


    public List<Pet> save(List<CreatePetRQ> createPetRQList) {
        List<Pet> newPetList = new ArrayList<>();
        Pet newPet;
        for (CreatePetRQ createPetRQ : createPetRQList) {
            newPet = Pet.builder().petType(createPetRQ.getPetType()).name(createPetRQ.getName()).build();
            petRepository.save(newPet);
            newPetList.add(newPet);
        }
        return newPetList;
    }

    public Pet findById(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new PetNotFound("Pet doesn't exists."));
    }
    public Pet addNewPetFeed(CreatePetFeedRQ createPetFeedRQ) {

        return null;
    }
    /*//Save several Pets at the same time
    public List<Pet> save(List<Pet> petList) throws PetException {
        List<Pet> newPetList = new ArrayList<>();
        for (Pet pet : petList) {
            newPetList.add(this.petRepository.save(pet));
        }
        return newPetList;
    }
*/
    /*public Pet save(Pet pet) throws PetException {
        if (this.checkIfPetIsOnShelter(pet)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Pet is already on database.");
        }
        return this.petRepository.save(pet);
    }*/

    public boolean checkIfPetIsOnShelter(Pet pet) {
        if (pet.getId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Pet not found in the refugee.");
        }
        return this.petRepository.existsById(pet.getId());
    }

    public Pet updateName(Long id, String name) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new PetNotFound("Pet doesn't exists."));
        pet.setName(name);
        return petRepository.save(pet);
    }
}
