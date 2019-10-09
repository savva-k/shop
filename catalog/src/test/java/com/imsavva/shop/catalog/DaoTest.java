package com.imsavva.shop.catalog;

import com.imsavva.shop.catalog.model.dto.Product;
import com.imsavva.shop.catalog.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

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
        Product persistedProduct = productRepository.createProduct(product);
        assertNotNull(persistedProduct.getId());
    }
}
