package com.example.productcompositeservice.openfeignClients;

import com.example.productcompositeservice.dto.ReviewDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "reviews", url = "http://localhost:8080/review-service")
public interface ReviewsFeignClient {

    @GetMapping("/api/reviews/product/{id}")
    List<ReviewDto> getReviewsByProductid(@PathVariable Long id);
}
