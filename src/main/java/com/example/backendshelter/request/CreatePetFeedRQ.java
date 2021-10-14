package com.example.backendshelter.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePetFeedRQ {
    private long petId;
    private long feedId;
}