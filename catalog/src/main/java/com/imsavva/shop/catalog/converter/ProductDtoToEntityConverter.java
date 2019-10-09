package com.imsavva.shop.catalog.converter;

import com.imsavva.shop.catalog.model.dto.Product;
import com.imsavva.shop.catalog.model.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;

public class ProductDtoToEntityConverter implements Converter<Product, ProductEntity> {
    @Override
    public ProductEntity convert(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setName(product.getName());
        return entity;
    }
}
