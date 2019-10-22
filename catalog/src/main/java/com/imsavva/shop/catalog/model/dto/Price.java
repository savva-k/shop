package com.imsavva.shop.catalog.model.dto;

import com.imsavva.shop.catalog.model.PriceType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Price {
    private Long id;
    private Long productId;
    private PriceType type;
    private BigDecimal value;
    private LocalDate date;

    public Price() {
    }

    public Price(PriceType type, BigDecimal price) {
        this.type = type;
        this.value = price;
    }
}
