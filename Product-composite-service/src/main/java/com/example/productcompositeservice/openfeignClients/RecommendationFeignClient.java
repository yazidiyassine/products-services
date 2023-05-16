package com.example.productcompositeservice.openfeignClients;

import com.example.productcompositeservice.dto.RecommendationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "recommendations", url = "http://localhost:8080/recommendation-service")
public interface RecommendationFeignClient {

    @GetMapping("/api/recommendations/product/{id}")
    List<RecommendationDto> getRecommendationsByProductid(@PathVariable Long id);
}
