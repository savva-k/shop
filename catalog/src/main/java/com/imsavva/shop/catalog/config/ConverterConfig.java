package com.imsavva.shop.catalog.config;

import com.imsavva.shop.catalog.converter.PriceDtoToEntityConverter;
import com.imsavva.shop.catalog.converter.PriceEntityToDtoConverter;
import com.imsavva.shop.catalog.converter.ProductDtoToEntityConverter;
import com.imsavva.shop.catalog.converter.ProductEntityToDtoConverter;
import com.imsavva.shop.catalog.model.dto.Price;
import com.imsavva.shop.catalog.model.dto.Product;
import com.imsavva.shop.catalog.model.entity.PriceEntity;
import com.imsavva.shop.catalog.model.entity.ProductEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ConverterConfig {

    @Bean
    public Converter<ProductEntity, Product> productEntityToDtoConverter(
            Converter<PriceEntity, Price> priceEntityToDtoConverter
    ) {
        return new ProductEntityToDtoConverter(priceEntityToDtoConverter);
    }

    @Bean
    public Converter<Product, ProductEntity> productDtoToEntityConverter(
            Converter<Price, PriceEntity> priceDtoToEntityConverter
    ) {
        return new ProductDtoToEntityConverter(priceDtoToEntityConverter);
    }

    @Bean
    public Converter<Price, PriceEntity> priceDtoToEntityConverter() {
        return new PriceDtoToEntityConverter();
    }

    @Bean
    Converter<PriceEntity, Price> priceEntityToDtoConverter() {
        return new PriceEntityToDtoConverter();
    }
}
