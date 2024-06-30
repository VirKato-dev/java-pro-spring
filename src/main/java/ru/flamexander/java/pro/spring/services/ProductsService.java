package ru.flamexander.java.pro.spring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flamexander.java.pro.spring.entities.Product;
import ru.flamexander.java.pro.spring.repositories.ListRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ListRepository<Product> products;

    public List<Product> getProducts() {
        return products.getAll();
    }

    public Product getProduct(Long id) {
        return products.findById(id).orElseThrow();
    }

    public Product createProduct(Product product) {
        return products.save(product);
    }
}
