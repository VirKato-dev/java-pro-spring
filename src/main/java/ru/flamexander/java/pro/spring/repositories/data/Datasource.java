package ru.flamexander.java.pro.spring.repositories.data;

import java.util.List;

public interface Datasource<T> {
    List<T> getData();
}
