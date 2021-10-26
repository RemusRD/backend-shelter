package com.example.backendshelter.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FactProvider {
    private final RestTemplate restTemplate;
    private final String url;

    public FactProvider(RestTemplate restTemplate,
                        @Value("${shelter.cat.fact.provider.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public String getFact() {
        final var response = restTemplate.getForEntity(url, FactResponse.class);
        return response.getBody().getFact();
    }
}
