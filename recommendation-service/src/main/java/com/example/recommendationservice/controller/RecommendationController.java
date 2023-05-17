package com.example.recommendationservice.controller;

import com.example.recommendationservice.dto.RecommendationRequest;
import com.example.recommendationservice.dto.RecommendationResponse;
import com.example.recommendationservice.model.Recommendation;

import com.example.recommendationservice.services.RecommendationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/recommendations")
@Slf4j
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
    @CircuitBreaker(name = "product_compo", fallbackMethod = "recommendationsByProductFallback")
    @TimeLimiter(name = "product_compo")
    @Retry(name = "product_compo")
    public CompletableFuture<List<RecommendationResponse>> getAllRecommendationByProductid(@PathVariable Long productid){
        return CompletableFuture.supplyAsync(() -> service.getAllRecommendationByProductid(productid));
    }

    public CompletableFuture<List<RecommendationResponse>> recommendationsByProductFallback(Long productid, Throwable e) {
        log.info("error getting recommendations of the product {}, caused by : {} ",productid, e.getMessage());
        return CompletableFuture.completedFuture(null);
    }
}
