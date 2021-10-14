package com.example.backendshelter.controller.request;

import com.example.backendshelter.model.PetType;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePetRQ {
    private PetType petType;
    @NotBlank(message = "Name is a mandatory field.")
    private String name;
}
