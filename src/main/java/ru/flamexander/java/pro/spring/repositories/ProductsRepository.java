package ru.flamexander.java.pro.spring.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.flamexander.java.pro.spring.entities.Product;
import ru.flamexander.java.pro.spring.repositories.data.Datasource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductsRepository implements ListRepository<Product> {

    private final Datasource<Product> datasource;

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        for (Product p : datasource.getData()) {
            Optional<Product> product = findById(p.getId());
            product.ifPresent(products::add);
        }
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = null;
        for (Product p : datasource.getData()) {
            if (p.getId().equals(id)) {
                product = p;
                break;
            }
        }
        return product == null ? Optional.empty() : Optional.of(product);
    }

    @Override
    public Product save(Product product) {
        Product updatedProduct = null;
        if (product.getId() == null) {
            // create
            updatedProduct = new Product(datasource.getData().size() + 1L, product.getTitle(), product.getPrice());
            datasource.getData().add(updatedProduct);
        } else {
            // update
            updatedProduct = findById(product.getId()).orElseThrow();
            updatedProduct.setTitle(product.getTitle());
            updatedProduct.setPrice(product.getPrice());
        }
        return updatedProduct;
    }
}
