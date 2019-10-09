package com.imsavva.shop.catalog.config;

import com.imsavva.shop.catalog.converter.ProductDtoToEntityConverter;
import com.imsavva.shop.catalog.converter.ProductEntityToDtoConverter;
import com.imsavva.shop.catalog.model.dto.Product;
import com.imsavva.shop.catalog.model.entity.ProductEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ConverterConfig {

    @Bean
    public Converter<ProductEntity, Product> productEntityToDtoConverter() {
        return new ProductEntityToDtoConverter();
    }

    @Bean
    public Converter<Product, ProductEntity> productDtoToEntityConverter() {
        return new ProductDtoToEntityConverter();
    }
}
