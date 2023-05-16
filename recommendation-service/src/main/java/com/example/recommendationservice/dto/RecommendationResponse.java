package com.example.recommendationservice.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecommendationResponse {
    private Long  productid;
    private String author;
    private  int rate;
    private String content;
}
