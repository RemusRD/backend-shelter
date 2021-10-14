package com.example.backendshelter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Feed {

    @EmbeddedId
    private PetFeedId compositeId;

    private LocalDateTime feedTime;

    @ManyToOne
    @MapsId("petId")
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @MapsId("foodId")
    @JoinColumn(name = "food_id")
    private Food food;

}
