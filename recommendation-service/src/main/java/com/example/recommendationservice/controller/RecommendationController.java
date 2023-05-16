package com.example.recommendationservice.controller;

import com.example.recommendationservice.dto.RecommendationRequest;
import com.example.recommendationservice.dto.RecommendationResponse;
import com.example.recommendationservice.model.Recommendation;

import com.example.recommendationservice.services.RecommendationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {
    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecommendationResponse createRecommendation(@RequestBody RecommendationRequest recommendation){
       return service.createRecommendation(recommendation);
    }

    @GetMapping("/{id}")
    public RecommendationResponse getRecommendationById(@PathVariable Long id){
         return  service.getRecommendationById(id);
    }

    @GetMapping()
    public List<RecommendationResponse> getAllRecommendations(){
        return service.getAllRecommendations();
    }

    @PutMapping("/{id}")
    public RecommendationResponse updateRecommendation(@PathVariable Long id,@RequestBody RecommendationRequest recommendation){
       return service.updateRecommendation(id,recommendation);
    }
    @DeleteMapping("/{id}")
    public RecommendationResponse deleteRecommendation(@PathVariable Long id){
      return  service.deleteRecommendation(id);
    }

    @GetMapping("/product/{productid}")
    public List<RecommendationResponse> getAllRecommendationByProductid(@PathVariable Long productid){
        return service.getAllRecommendationByProductid(productid);
    }
}
