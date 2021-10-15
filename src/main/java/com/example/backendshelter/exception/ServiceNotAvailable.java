package com.example.backendshelter.exception;

public class ServiceNotAvailable extends RuntimeException {
    public ServiceNotAvailable(String message) {
        super(message);
    }
}