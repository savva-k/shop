package com.imsavva.shop.catalog.converter;

import com.imsavva.shop.catalog.model.dto.Price;
import com.imsavva.shop.catalog.model.dto.Product;
import com.imsavva.shop.catalog.model.entity.PriceEntity;
import com.imsavva.shop.catalog.model.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductEntityToDtoConverter implements Converter<ProductEntity, Product> {

    private Converter<PriceEntity, Price> priceEntityToDtoConverter;

    @Autowired
    public ProductEntityToDtoConverter(Converter<PriceEntity, Price> priceEntityToDtoConverter) {
        this.priceEntityToDtoConverter = priceEntityToDtoConverter;
    }

    @Override
    public Product convert(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        List<PriceEntity> priceEntities = productEntity.getPrices() != null ? productEntity.getPrices() : Collections.emptyList();

        product.setPrices(priceEntities
                .stream()
                .map(priceEntityToDtoConverter::convert)
                .collect(Collectors.toList())
        );

        return product;
    }
}
