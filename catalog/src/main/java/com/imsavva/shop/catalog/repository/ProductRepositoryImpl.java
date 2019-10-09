package com.imsavva.shop.catalog.repository;

import com.imsavva.shop.catalog.model.dto.Product;
import com.imsavva.shop.catalog.model.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private EntityManager entityManager;
    private Converter<ProductEntity, Product> productEntityToDtoConverter;
    private Converter<Product, ProductEntity> productDtoToEntityConverter;

    @Autowired
    public ProductRepositoryImpl(
            EntityManager entityManager,
            Converter<ProductEntity, Product> productEntityToDtoConverter,
            Converter<Product, ProductEntity> productDtoToEntityConverter
    ) {
        this.entityManager = entityManager;
        this.productDtoToEntityConverter = productDtoToEntityConverter;
        this.productEntityToDtoConverter = productEntityToDtoConverter;
    }

    public Product createProduct(Product product) {
        ProductEntity entity = productDtoToEntityConverter.convert(product);
        entityManager.persist(entity);
        return productEntityToDtoConverter.convert(entity);
    }

    public Optional<Product> findProduct(Long id) {
        ProductEntity productEntity = entityManager.find(ProductEntity.class, id);
        return Optional.ofNullable(productEntityToDtoConverter.convert(productEntity));
    }
}
