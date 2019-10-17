package com.imsavva.shop.catalog.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private List<Price> prices;
}
