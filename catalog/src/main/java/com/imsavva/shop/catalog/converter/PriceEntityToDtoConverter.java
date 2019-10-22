package com.imsavva.shop.catalog.converter;

import com.imsavva.shop.catalog.model.dto.Price;
import com.imsavva.shop.catalog.model.entity.PriceEntity;
import org.springframework.core.convert.converter.Converter;

public class PriceEntityToDtoConverter implements Converter<PriceEntity, Price> {

    @Override
    public Price convert(PriceEntity priceEntity) {
        Price price = new Price();

        price.setId(priceEntity.getId());
        price.setProductId(priceEntity.getProductId());
        price.setType(priceEntity.getType());
        price.setValue(priceEntity.getPrice());
        price.setDate(priceEntity.getDate());

        return price;
    }
}
