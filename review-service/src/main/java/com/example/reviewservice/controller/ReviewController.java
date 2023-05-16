package com.example.reviewservice.controller;

import com.example.reviewservice.dto.ReviewRequestDto;
import com.example.reviewservice.dto.ReviewResponseDto;
import com.example.reviewservice.model.Review;
import com.example.reviewservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addReview(@RequestBody ReviewRequestDto reviewRequest) {

        reviewService.addReview(reviewRequest);
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
    public List<Review> getAllReviews(){

        return reviewService.getAllReviews();
    }

    @GetMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponseDto> getReviewsByProductId(@PathVariable Long id) {
        return reviewService.getReviewsByProductId(id);
    }
}
