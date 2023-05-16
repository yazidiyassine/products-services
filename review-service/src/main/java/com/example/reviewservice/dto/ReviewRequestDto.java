package com.example.reviewservice.dto;

import lombok.Data;

@Data
public class ReviewRequestDto {

    private Long reviewid;

    private Long productid;

    private String author;

    private String subject;

    private String content;
}
