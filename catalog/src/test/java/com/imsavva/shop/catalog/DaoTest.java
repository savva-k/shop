package com.imsavva.shop.catalog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DaoTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void contextLoads() {
    }

    @Test
    public void shouldPersistProducts() {
        Product product = new Product();
        product.setName("test product");
        entityManager.persist(product);
    }
}
