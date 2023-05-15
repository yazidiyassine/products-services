package com.project.productservice.services;

import com.project.productservice.dto.ProductDTO;
import com.project.productservice.response.ProductResponse;

import java.util.List;

public interface ProductService {
    public  ProductDTO createProdct(ProductDTO productRequest);
    public ProductDTO getProductById(Long id);
    public List<ProductDTO> getAllProducts();
}
