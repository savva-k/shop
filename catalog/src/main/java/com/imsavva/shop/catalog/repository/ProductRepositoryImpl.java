package com.imsavva.shop.catalog.repository;

import com.imsavva.shop.catalog.mapper.ProductMapper;
import com.imsavva.shop.catalog.model.dto.Product;
import com.imsavva.shop.catalog.model.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private EntityManager entityManager;
    private ProductMapper productMapper;

    @Autowired
    public ProductRepositoryImpl(
            EntityManager entityManager,
            ProductMapper productMapper
    ) {
        this.entityManager = entityManager;
        this.productMapper = productMapper;
    }

    public Product createProduct(Product product) {
        ProductEntity entity = productMapper.productToProductEntity(product);
        entityManager.persist(entity);
        return productMapper.productEntityToProduct(entity);
    }

    public Optional<Product> findProduct(Long id) {
        ProductEntity productEntity = entityManager.find(ProductEntity.class, id);
        return Optional.ofNullable(productMapper.productEntityToProduct(productEntity));
    }
}
