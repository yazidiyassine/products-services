package com.example.reviewservice.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewResponseDto {

    private Long reviewid;

    private Long productid;

    private String author;

    private String subject;

    private String content;
}
