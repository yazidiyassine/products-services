package com.example.productcompositeservice.controller;

import com.example.productcompositeservice.dto.ProductDto;
import com.example.productcompositeservice.openfeign_products.PrductFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-composites")
public class ProductCompositeController {

    private final PrductFeignClient prductFeignClient;

    public ProductCompositeController(PrductFeignClient prductFeignClient) {
        this.prductFeignClient = prductFeignClient;
    }

    @GetMapping("{id}")
    public ProductDto test(@PathVariable Long id){
        return prductFeignClient.getProductById(id);
    }
}
