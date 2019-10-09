package com.imsavva.shop.catalog.repository;

import com.imsavva.shop.catalog.model.dto.Product;

import java.util.Optional;

public interface ProductRepository {
    Product createProduct(Product product);

    Optional<Product> findProduct(Long id);
}
