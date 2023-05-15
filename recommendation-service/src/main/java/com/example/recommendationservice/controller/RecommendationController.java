package com.example.recommendationservice.controller;

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
    public  Recommendation createRecommendation(@RequestBody Recommendation recommendation){
       return service.createRecommendation(recommendation);
    }

    @GetMapping("/{id}")
    public Recommendation getRecommendationById(@PathVariable Long id){
         return    service.getRecommendationById(id);
    }

    @GetMapping()
    public List<Recommendation> getAllRecommendations(){
        return service.getAllRecommendations();
    }

    @PutMapping("/{id}")
    public Recommendation updateRecommendation(@PathVariable Long id,@RequestBody Recommendation recommendation){
       return service.updateRecommendation(id,recommendation);
    }
    @DeleteMapping("/{id}")
    public Recommendation deleteRecommendation(@PathVariable Long id){
      return  service.deleteRecommendation(id);
    }
}
