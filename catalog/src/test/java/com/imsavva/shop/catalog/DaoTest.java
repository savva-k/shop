package com.imsavva.shop.catalog;

import com.imsavva.shop.catalog.model.PriceType;
import com.imsavva.shop.catalog.model.dto.Price;
import com.imsavva.shop.catalog.model.dto.Product;
import com.imsavva.shop.catalog.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DaoTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void shouldPersistProducts() {
        Product product = new Product();
        product.setName("Test product");
        product.setDescription("Test product description");
        Product entity = productRepository.createProduct(product);
        assertNotNull(entity.getId());
        assertNotNull(entity.getDescription());
    }

    @Test
    public void shouldPersistProductsWithPrices() {
        List<Price> prices = new ArrayList<>();
        prices.add(new Price(PriceType.DEFAULT, new BigDecimal(500)));

        Product product = new Product();
        product.setName("Test product");
        product.setPrices(prices);

        Product entity = productRepository.createProduct(product);
        assertNotNull(entity.getId());
        assertEquals(product.getPrices().get(0).getPriceValue(), entity.getPrices().get(0).getPriceValue());
    }
}
