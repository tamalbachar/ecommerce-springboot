package com.tapanstea.tapanstea_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tapanstea.tapanstea_backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
