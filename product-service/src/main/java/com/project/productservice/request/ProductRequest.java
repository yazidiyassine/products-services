package com.project.productservice.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class ProductRequest {
    private String name;
    private  double weight;
}
