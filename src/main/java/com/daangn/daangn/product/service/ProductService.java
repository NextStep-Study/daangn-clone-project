package com.daangn.daangn.product.service;

import com.daangn.daangn.product.entity.Product;
import com.daangn.daangn.product.entity.ProductStatus;
import com.daangn.daangn.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllByStatus(ProductStatus status) {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findById(Long productId) {
        return productRepository.findById(productId).get();
    }

    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }
}
