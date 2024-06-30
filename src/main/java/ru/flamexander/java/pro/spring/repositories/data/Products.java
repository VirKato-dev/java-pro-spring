package ru.flamexander.java.pro.spring.repositories.data;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.flamexander.java.pro.spring.entities.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Products implements Datasource<Product> {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Milk", BigDecimal.valueOf(152, 1)),
                new Product(2L, "Bread", BigDecimal.valueOf(105, 1))
        ));
    }

    @Override
    public List<Product> getData() {
        return products;
    }
}
