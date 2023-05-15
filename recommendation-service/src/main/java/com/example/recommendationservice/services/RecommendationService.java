package com.example.recommendationservice.services;

import com.example.recommendationservice.model.Recommendation;

import java.util.List;

public interface RecommendationService {
    Recommendation createRecommendation(Recommendation recommendation);
     Recommendation getRecommendationById(Long id);
     List<Recommendation> getAllRecommendations();

    Recommendation updateRecommendation(Long id, Recommendation recommendation);

    Recommendation deleteRecommendation(Long id);
}
