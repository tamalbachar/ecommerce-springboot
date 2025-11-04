package com.tapanstea.tapanstea_backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.tapanstea.tapanstea_backend.model.Product;
import com.tapanstea.tapanstea_backend.repository.ProductRepository;
import com.tapanstea.tapanstea_backend.service.ProductService;

@Service  // 👈 This is critical
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = productRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            existing.setImageUrl(product.getImageUrl());
            return productRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
