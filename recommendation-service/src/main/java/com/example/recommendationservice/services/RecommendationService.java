package com.example.recommendationservice.services;

import com.example.recommendationservice.dao.RecommendationDao;
import com.example.recommendationservice.dto.RecommendationRequest;
import com.example.recommendationservice.dto.RecommendationResponse;
import com.example.recommendationservice.model.Recommendation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationDao recommendationDao;

    public RecommendationResponse createRecommendation(RecommendationRequest recommendation) {
        Recommendation recommendation1 = new Recommendation();
        recommendation1.setAuthor(recommendation.getAuthor());
        recommendation1.setContent(recommendation.getContent());
        recommendation1.setProductid(recommendation.getProductid());
        recommendation1.setRate(recommendation.getRate());

        recommendation1 = recommendationDao.save(recommendation1);


        return RecommendationResponse.builder().productid(recommendation1.getProductid())
                .author(recommendation1.getAuthor()).content(recommendation1.getContent())
                .rate(recommendation1.getRate()).build();
    }


    public RecommendationResponse getRecommendationById(Long id) {
        Recommendation recommendation = recommendationDao.findById(id).orElseThrow();
        if (recommendation.getRecommendationid() != null) {
            return RecommendationResponse.builder()
                    .productid(recommendation.getProductid()).author(recommendation.getAuthor())
                    .content(recommendation.getContent()).rate(recommendation.getRate()).build();
        } else
            return null;
    }

    public List<RecommendationResponse> getAllRecommendations() {
        List<Recommendation> recommendations = recommendationDao.findAll();
        return getRecommendationResponses(recommendations);
    }


    public RecommendationResponse updateRecommendation(Long id, RecommendationRequest recommendationRequest) {
        Recommendation recommendation = recommendationDao.findById(id).orElseThrow();
       if (recommendation.getRecommendationid() != null) {
            recommendation.setAuthor(recommendationRequest.getAuthor());
            recommendation.setContent(recommendationRequest.getContent());
            recommendation.setProductid(recommendationRequest.getProductid());
            recommendation.setRate(recommendationRequest.getRate());

            recommendation = recommendationDao.save(recommendation);

            return RecommendationResponse.builder().productid(recommendation.getProductid())
                    .author(recommendation.getAuthor()).content(recommendation.getContent())
                    .rate(recommendation.getRate()).build();
        } else
            return null;

    }

    public RecommendationResponse deleteRecommendation(Long id) {
        Recommendation recommendation = recommendationDao.findById(id).orElseThrow();
        if (recommendation.getRecommendationid() != null) {
            RecommendationResponse recommendationResponse = RecommendationResponse.builder().productid(recommendation.getProductid())
                    .author(recommendation.getAuthor()).content(recommendation.getContent())
                    .rate(recommendation.getRate()).build();
            recommendationDao.deleteById(id);
            return recommendationResponse;
        } else
            return null;
    }

    public List<RecommendationResponse> getAllRecommendationByProductid(Long productid) {
        List<Recommendation> recommendations = recommendationDao.getAllRecommendationByProductid(productid);
        return getRecommendationResponses(recommendations);
    }

    private List<RecommendationResponse> getRecommendationResponses(List<Recommendation> recommendations) {
        if (!recommendations.isEmpty()) {
            List<RecommendationResponse> recommendationResponses = new ArrayList<>();
            for (Recommendation recommendation : recommendations) {
                RecommendationResponse recommendationResponse = RecommendationResponse.builder()
                        .productid(recommendation.getProductid())
                        .author(recommendation.getAuthor())
                        .content(recommendation.getContent())
                        .rate(recommendation.getRate())
                        .build();
                recommendationResponses.add(recommendationResponse);
            }
            return recommendationResponses;
        } else {
            return null;
        }
    }
}
