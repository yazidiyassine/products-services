package com.example.recommendationservice.dao;

import com.example.recommendationservice.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationDao extends JpaRepository<Recommendation,Long> {
}
