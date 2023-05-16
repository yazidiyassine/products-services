package com.example.recommendationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RecommendationRequest {

    private Long  productid;
    private String author;
    private  int rate;
    private String content;
}
