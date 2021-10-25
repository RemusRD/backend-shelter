package com.example.backendshelter.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class FactProvider {
    private final RestTemplate restTemplate;

    public String getFact() {
        final var response = restTemplate.getForEntity("https://catfact.ninja/fact", FactResponse.class);
        return response.getBody().getFact();
    }
}
