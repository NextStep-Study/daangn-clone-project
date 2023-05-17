package com.daangn.daangn.product.controller;

import com.daangn.daangn.product.entity.Product;
import com.daangn.daangn.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity findAll() {
        List<Product> results = productService.findAll();
        return ResponseEntity.ok(results);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam("status") String status) {
        List<Product> results = productService.findAll();
        return ResponseEntity.ok(results);
    }


}
