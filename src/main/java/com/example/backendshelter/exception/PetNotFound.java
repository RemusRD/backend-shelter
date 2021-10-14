package com.example.backendshelter.exception;

public class PetNotFound extends RuntimeException {
    public PetNotFound(String message) {
        super(message);
    }
}
