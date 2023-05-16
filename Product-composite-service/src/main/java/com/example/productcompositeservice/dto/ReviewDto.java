package com.example.productcompositeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewDto {

    @JsonProperty("productid")
    private Long productid;
    @JsonProperty("author")
    private String author;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("content")
    private String content;

}
