package ru.flamexander.java.pro.spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flamexander.java.pro.spring.entities.Product;
import ru.flamexander.java.pro.spring.services.ProductsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProduct(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }
}
