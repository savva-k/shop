package com.imsavva.shop.catalog.mapper;

import com.imsavva.shop.catalog.model.dto.Price;
import com.imsavva.shop.catalog.model.dto.Product;
import com.imsavva.shop.catalog.model.entity.PriceEntity;
import com.imsavva.shop.catalog.model.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity productToProductEntity(Product product);

    Product productEntityToProduct(ProductEntity productEntity);

    PriceEntity priceToPriceEntity(Price price);

    Price priceEntityToPrice(PriceEntity priceEntity);
}
