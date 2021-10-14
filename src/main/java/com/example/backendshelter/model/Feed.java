package com.example.backendshelter.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="Feed")
@Entity
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private LocalDateTime lunchTime;

    @OneToOne
    private Food food;

    @OneToOne
    private Pet pet;

    @OneToMany
    private List<Pet> pets = new ArrayList<>();
}
