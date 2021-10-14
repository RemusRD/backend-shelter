package com.example.backendshelter.service;

import com.example.backendshelter.model.Feed;
import com.example.backendshelter.model.Pet;
import com.example.backendshelter.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedService {

    private final FeedRepository feedRepository;

    public FeedService(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public Optional<Feed> findById(Long id) {
        return feedRepository.findById(id);
    }
}
