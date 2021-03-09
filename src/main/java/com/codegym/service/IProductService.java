package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findALl();

    Page<Product> findALl(Pageable pageable);

    Product findById(Long id);

    Product save(Product product);

    void deleteById(Long id);

    List<Product> findProductName(String name);
}
