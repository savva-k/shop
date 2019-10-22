package com.imsavva.shop.catalog.model.entity;

import com.imsavva.shop.catalog.model.PriceType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "price")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "product_id")
    private Long productId;
    private PriceType type;
    private BigDecimal price;
    private LocalDate date;
}
