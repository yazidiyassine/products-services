package com.example.productcompositeservice.controller;

import com.example.productcompositeservice.dto.ProductDto;
import com.example.productcompositeservice.dto.ReviewDto;
import com.example.productcompositeservice.openfeignClients.ProductFeignClient;
import com.example.productcompositeservice.openfeignClients.ReviewsFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product_composite")
public class ProductCompositeController {

    private final ProductFeignClient productFeignClient;
    private final ReviewsFeignClient reviewsFeignClient;

    public ProductCompositeController(ProductFeignClient productFeignClient, ReviewsFeignClient reviewsFeignClient) {
        this.productFeignClient = productFeignClient;
        this.reviewsFeignClient = reviewsFeignClient;
    }

    @GetMapping("/{id}")
    public ProductDto details(@PathVariable Long id) {
        return productFeignClient.getProductById(id);
    }


    @GetMapping("/reviews/{id}")
    public List<ReviewDto> reviews(@PathVariable Long id) {
        return reviewsFeignClient.getReviewsByProductid(id);
    }
}

