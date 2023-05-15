package com.project.productservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private String name;
    private  String description;
    private double weight;
}

