package com.daangn.daangn.product.service;

import com.daangn.daangn.product.dto.ProductDto;
import com.daangn.daangn.product.entity.Product;
import com.daangn.daangn.product.entity.ProductStatus;
import com.daangn.daangn.product.mapper.ProductMapper;
import com.daangn.daangn.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllByStatus(ProductStatus status) {
        return productRepository.findByStatus(status);
    }

    public Product findById(Long productId) {
        return productRepository.findById(productId).get();
    }

    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }

    public Long createNewProduct(Product product) {
        Product saved = productRepository.save(product);
        return saved.getId();
    }

    public Product updateById(ProductDto.Patch patchRequest, Long productId) {
        Product targetProduct = findById(productId);
        productMapper.patchRequestToEntity(patchRequest, targetProduct);

        productRepository.save(targetProduct);

        return targetProduct;
    }
}
