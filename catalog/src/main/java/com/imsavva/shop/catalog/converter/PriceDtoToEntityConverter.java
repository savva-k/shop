package com.imsavva.shop.catalog.converter;

import com.imsavva.shop.catalog.model.dto.Price;
import com.imsavva.shop.catalog.model.entity.PriceEntity;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public class PriceDtoToEntityConverter implements Converter<Price, PriceEntity> {
    @Override
    public PriceEntity convert(Price price) {
        PriceEntity entity = new PriceEntity();

        entity.setId(price.getId());
        entity.setProductId(price.getProductId());
        entity.setType(price.getType());
        entity.setPrice(price.getValue());
        entity.setDate(LocalDate.now());

        return entity;
    }
}
