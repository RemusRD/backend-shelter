package com.example.backendshelter.service;

import com.example.backendshelter.provider.FactProvider;
import org.springframework.stereotype.Service;

@Service
public class FactService {
    private final FactProvider factProvider;

    public FactService(FactProvider factProvider) {
        this.factProvider = factProvider;
    }


    public String getFact() {
        return factProvider.getFact();
    }
}
