package com.example.backendshelter.controller.response;

import com.example.backendshelter.model.PetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PetResponse {
    private Long id;
    private PetType petType;
    private String name;
}
