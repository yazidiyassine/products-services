package com.example.productcompositeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("weight")
    private double weight;
}
