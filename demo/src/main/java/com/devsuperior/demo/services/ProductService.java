package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.ProductDTO;
import com.devsuperior.demo.entities.Product;
import com.devsuperior.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> result = productRepository.findById(id);
        Product product = result.get();

        ProductDTO dto = new ProductDTO(product);
        return dto;
    }

}
