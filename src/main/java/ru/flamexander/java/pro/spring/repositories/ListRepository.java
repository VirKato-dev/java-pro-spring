package ru.flamexander.java.pro.spring.repositories;

import java.util.List;
import java.util.Optional;

public interface ListRepository<T> {
    List<T> getAll();
    Optional<T> findById(Long id);
    T save(T t);
}
