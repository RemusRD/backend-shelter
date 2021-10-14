package com.example.backendshelter.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="Pet")
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    private PetType petType;


    private String name;

    @OneToMany(mappedBy = "pet")
    private List<Feed> feedList;
}
