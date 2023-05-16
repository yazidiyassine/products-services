package com.example.reviewservice.service;

import com.example.reviewservice.dto.ReviewRequestDto;
import com.example.reviewservice.dto.ReviewResponseDto;
import com.example.reviewservice.model.Review;
import com.example.reviewservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public ReviewResponseDto addReview(ReviewRequestDto reviewRequestDto) {
        Review review = new Review();
        review.setProductid(reviewRequestDto.getProductid());
        review.setAuthor(reviewRequestDto.getAuthor());
        review.setSubject(reviewRequestDto.getSubject());
        review.setContent(reviewRequestDto.getContent());
        reviewRepository.save(review);
        return ReviewResponseDto.builder()
                .productid(review.getProductid()).author(review.getAuthor())
                .subject(review.getSubject()).content(review.getContent()).build();
    }

    public ReviewResponseDto getReview(Long id) {

        Review review = reviewRepository.findById(id).orElseThrow();
        return ReviewResponseDto.builder().reviewid(review.getReviewid())
                .productid(review.getProductid()).author(review.getAuthor())
                .subject(review.getSubject()).content(review.getContent()).build();
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public ReviewResponseDto updateReview(Long id, Review review) {
        Review reviewToUpdate = reviewRepository.findById(id).orElseThrow();
        reviewToUpdate.setAuthor(review.getAuthor());
        reviewToUpdate.setSubject(review.getSubject());
        reviewToUpdate.setContent(review.getContent());
        reviewToUpdate.setProductid(review.getProductid());
        reviewRepository.save(reviewToUpdate);
        return ReviewResponseDto.builder().reviewid(review.getReviewid())
                .productid(reviewToUpdate.getProductid()).author(reviewToUpdate.getAuthor())
                .subject(reviewToUpdate.getSubject()).content(reviewToUpdate.getContent()).build();
    }

    public List<ReviewResponseDto> getReviewsByProductId(Long id) {
        List<Review> reviews = reviewRepository.getReviewsByProductid(id);

        return reviews.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ReviewResponseDto convertToDto(Review review) {
        return ReviewResponseDto.builder()
                .reviewid(review.getReviewid())
                .productid(review.getProductid())
                .author(review.getAuthor())
                .subject(review.getSubject())
                .content(review.getContent())
                .build();
    }


    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

}
