package com.example.productcompositeservice.openfeign_products;

import com.example.productcompositeservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "http://localhost:8080", path = "/api/products")
public interface PrductFeignClient {

    @GetMapping("/{id}")
     ProductDto getProductById(@PathVariable Long id);
}
