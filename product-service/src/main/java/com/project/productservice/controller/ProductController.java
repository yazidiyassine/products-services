package com.project.productservice.controller;

import com.project.productservice.dto.ProductDTO;
import com.project.productservice.request.ProductRequest;
import com.project.productservice.response.ProductResponse;
import com.project.productservice.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;
    Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    Environment environment;
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void createProduct(@RequestBody ProductRequest productRequest){
        ProductDTO dto = ProductDTO.builder().build();
        BeanUtils.copyProperties(productRequest,dto);
        service.createProdct(dto);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id){
    logger.info("instance id : "+environment.getProperty("local.server.port"));
    ProductResponse productResponse = ProductResponse.builder().build();
    ProductDTO dto = service.getProductById(id);
    BeanUtils.copyProperties(dto,productResponse);
    return  productResponse;
    }

    @GetMapping()
    public List<ProductResponse> getAllProducts(){
        List<ProductDTO> dtos = service.getAllProducts();
        List<ProductResponse> responses = new ArrayList<>();
        for (ProductDTO dto : dtos
        ) {
            ProductResponse productResponse = ProductResponse.builder().build();
            BeanUtils.copyProperties(dto,productResponse);
            responses.add(productResponse);
        }
        return  responses;
    }
}
