package com.example.backendshelter.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    private Long shelterId;
}
