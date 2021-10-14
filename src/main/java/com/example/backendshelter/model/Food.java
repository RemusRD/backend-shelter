package com.example.backendshelter.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="Food")
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String description;
    private String brand;
}
