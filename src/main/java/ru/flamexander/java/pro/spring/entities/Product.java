package ru.flamexander.java.pro.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private Long id;
    private String title;
    private BigDecimal price;

    public Product(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }
}
