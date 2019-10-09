package com.imsavva.shop.catalog.converter;

import com.imsavva.shop.catalog.model.dto.Product;
import com.imsavva.shop.catalog.model.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;

public class ProductEntityToDtoConverter implements Converter<ProductEntity, Product> {
    @Override
    public Product convert(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        return product;
    }
}
