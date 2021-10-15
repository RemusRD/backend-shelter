package com.example.backendshelter.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Volunteer {
    @Id
    private Long id;

    @ManyToOne
    private Shelter shelter;
}
