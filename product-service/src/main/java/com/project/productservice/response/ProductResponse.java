package com.project.productservice.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class ProductResponse {
    private String name;
    private  double weight;

}
