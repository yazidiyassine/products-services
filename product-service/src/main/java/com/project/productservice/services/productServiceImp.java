package com.project.productservice.services;

import com.project.productservice.dao.ProductDao;
import com.project.productservice.dto.ProductDTO;
import com.project.productservice.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class productServiceImp implements  ProductService{
    private final  ProductDao dao;

    public productServiceImp(ProductDao dao) {
        this.dao = dao;
    }

    @Override
    public ProductDTO createProdct(ProductDTO product) {
        Product product1 = new Product();
        ProductDTO dto = ProductDTO.builder().build();
        BeanUtils.copyProperties(product,product1);
        Product product2 = dao.save(product1);
        BeanUtils.copyProperties(product2,dto);
        return dto;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        ProductDTO dto = ProductDTO.builder().build();
        Product product= dao.findById(id).get();
        BeanUtils.copyProperties(product,dto);
        return dto;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = dao.findAll();
        List<ProductDTO> dtos = new ArrayList<>();
        for (Product p : products
             ) {
            ProductDTO productDTO = ProductDTO.builder().build();
            BeanUtils.copyProperties(p,productDTO);
            dtos.add(productDTO);
        }
        return dtos;
    }
}
