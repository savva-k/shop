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

public class ProductDtoToEntityConverter implements Converter<Product, ProductEntity> {

    private Converter<Price, PriceEntity> priceDtoToEntityConverter;

    @Autowired
    public ProductDtoToEntityConverter(Converter<Price, PriceEntity> priceDtoToEntityConverter) {
        this.priceDtoToEntityConverter = priceDtoToEntityConverter;
    }

    @Override
    public ProductEntity convert(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        List<Price> prices = product.getPrices() != null ? product.getPrices() : Collections.emptyList();

        entity.setPrices(prices
                .stream()
                .map(priceDtoToEntityConverter::convert)
                .collect(Collectors.toList())
        );

        return entity;
    }
}
