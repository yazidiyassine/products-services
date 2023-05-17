package com.example.productcompositeservice.openfeignClients;

import com.example.productcompositeservice.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    private final Logger logger = LoggerFactory.getLogger(ProductFeignClientFallback.class);

    @Override
    public ProductDto getProductById(Long id) {
        logger.error("Fallback: Error getting the product by id: " + id);
        return null;
    }
}
