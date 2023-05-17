package com.example.productcompositeservice.openfeignClients;

import com.example.productcompositeservice.dto.ProductDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value =  "product", url = "http://localhost:8080/product-service/", fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient {

    @GetMapping("/api/products/{id}")
    ProductDto getProductById(@PathVariable Long id);
}
