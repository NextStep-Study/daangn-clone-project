package com.daangn.daangn.product.repository;

import com.daangn.daangn.product.entity.Product;
import com.daangn.daangn.product.entity.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByStatus(ProductStatus status);
}
