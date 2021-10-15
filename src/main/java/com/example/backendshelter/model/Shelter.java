package com.example.backendshelter.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Shelter {
    @Id
    private Long id;

    @OneToMany(mappedBy = "shelterId")
    private List<Volunteer> volunteers;

}
