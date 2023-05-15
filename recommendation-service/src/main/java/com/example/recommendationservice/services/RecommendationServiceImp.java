package com.example.recommendationservice.services;

import com.example.recommendationservice.dao.RecommendationDao;
import com.example.recommendationservice.model.Recommendation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImp implements RecommendationService {

    private final RecommendationDao recommendationDao;
    @Override
    public Recommendation createRecommendation(Recommendation recommendation) {
       return recommendationDao.save(recommendation);
    }

    @Override
    public Recommendation getRecommendationById(Long id) {
        Recommendation recommendation = recommendationDao.findById(id).get();
        if(recommendation==null)
        return recommendation;
        else
            return  null;
    }

    @Override
    public List<Recommendation> getAllRecommendations() {
        List<Recommendation> recommendations = recommendationDao.findAll();
        if(recommendations.isEmpty())
        return null;
        else
            return recommendations;
    }

    @Override
    public Recommendation updateRecommendation(Long id, Recommendation recommendation) {
        Recommendation recommendation1 = recommendationDao.findById(id).get();
        if(recommendation1!=null)
            return recommendationDao.save(recommendation);
        else
            return null;

    }

    @Override
    public Recommendation deleteRecommendation(Long id) {
        Recommendation recommendation = recommendationDao.findById(id).get();
        if(recommendation!=null)
        {
            recommendationDao.deleteById(id);
            return recommendation;
        }
        else
            return null;
    }
}
