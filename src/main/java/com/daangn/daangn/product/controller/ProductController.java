package com.daangn.daangn.product.controller;

import com.daangn.daangn.product.dto.ProductDto;
import com.daangn.daangn.product.entity.Product;
import com.daangn.daangn.product.entity.ProductStatus;
import com.daangn.daangn.product.mapper.ProductMapper;
import com.daangn.daangn.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> results = productService.findAll();
        return ResponseEntity.ok(results);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(@RequestParam("status") ProductStatus status) {
        List<Product> results = productService.findAllByStatus(status);
        return ResponseEntity.ok(results);
    }

    @PostMapping
    public ResponseEntity<?> createNewProduct(@RequestBody ProductDto.Post postRequest) {
        Product product = productMapper.postRequestToEntity(postRequest);
        Long savedId = productService.createNewProduct(product);

        URI location = createLocation(savedId);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductDto.Get> findById(@PathVariable("product-id") Long productId) {
        Product product = productService.findById(productId);
        ProductDto.Get getRequest = productMapper.entityToGetRequest(product);

        return ResponseEntity.ok(getRequest);
    }

    @PatchMapping("/{product-id}")
    public ResponseEntity<ProductDto.Get> updateById(@RequestBody ProductDto.Patch patchRequest, @PathVariable("product-id") Long productId) {
        Product product = productService.updateById(patchRequest, productId);
        ProductDto.Get getRequest = productMapper.entityToGetRequest(product);

        return ResponseEntity.ok(getRequest);
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<?> deleteById(@PathVariable("product-id") Long productId) {
        productService.deleteById(productId);

        return ResponseEntity.noContent().build();
    }

    private static URI createLocation(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
