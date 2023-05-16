package com.example.reviewservice.repository;

import com.example.reviewservice.dto.ReviewResponseDto;
import com.example.reviewservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

    List<Review> getReviewsByProductid(@PathVariable Long id);
}
