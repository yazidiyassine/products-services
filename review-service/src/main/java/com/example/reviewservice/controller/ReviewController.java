package com.example.reviewservice.controller;

import com.example.reviewservice.dto.ReviewRequestDto;
import com.example.reviewservice.dto.ReviewResponseDto;
import com.example.reviewservice.model.Review;
import com.example.reviewservice.service.ReviewService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponseDto addReview(@RequestBody ReviewRequestDto reviewRequest) {

        return reviewService.addReview(reviewRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponseDto updateReview(@PathVariable Long id, @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponseDto getReview(@PathVariable Long id) {
        return reviewService.getReview(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Review> getAllReviews() {

        return reviewService.getAllReviews();
    }

    @GetMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CircuitBreaker(name = "product_compo", fallbackMethod = "reviewsByProductFallback")
    @TimeLimiter(name = "product_compo")
    @Retry(name = "product_compo")
    public CompletableFuture<List<ReviewResponseDto>> getReviewsByProductId(@PathVariable Long id) {
        return CompletableFuture.supplyAsync(() -> reviewService.getReviewsByProductId(id));
    }

    public CompletableFuture<List<ReviewResponseDto>> reviewsByProductFallback(Long id, Throwable e) {
        log.info("error getting reviews of the product {}, caused by : {} ",id, e.getMessage());
        return CompletableFuture.completedFuture(null);
    }

}
