package com.tapanstea.tapanstea_backend.service;

import java.util.List;

import com.tapanstea.tapanstea_backend.model.Product;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
