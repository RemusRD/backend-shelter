package com.example.backendshelter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PetFeedId implements Serializable {
    @Column(name = "food_id")
    private Long foodId;

    @Column(name = "pet_id")
    private Long petId;
}
