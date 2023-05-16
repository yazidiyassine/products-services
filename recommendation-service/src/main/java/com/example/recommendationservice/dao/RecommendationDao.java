package com.example.recommendationservice.dao;

import com.example.recommendationservice.dto.RecommendationResponse;
import com.example.recommendationservice.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationDao extends JpaRepository<Recommendation,Long> {

    List<Recommendation> getAllRecommendationByProductid(Long productid);
}
