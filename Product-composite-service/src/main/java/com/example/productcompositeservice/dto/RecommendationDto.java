package com.example.productcompositeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecommendationDto {

    @JsonProperty("productid")
    private Long  productid;
    @JsonProperty("author")
    private String author;
    @JsonProperty("rate")
    private  int rate;
    @JsonProperty("content")
    private String content;
}
