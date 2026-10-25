package com.fsad.productmanagement.service.impl;

import com.fsad.productmanagement.dto.ProductRequest;
import com.fsad.productmanagement.dto.ProductResponse;
import com.fsad.productmanagement.entity.Product;
import com.fsad.productmanagement.exception.ResourceNotFoundException;
import com.fsad.productmanagement.repository.ProductRepository;
import com.fsad.productmanagement.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        Product product = new Product();
        mapToEntity(product, request);
        Product saved = productRepository.save(product);
        return mapToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getAll() {
        return productRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for id: " + id));
        return mapToResponse(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getByCategory(String category) {
        return productRepository.findByCategoryIgnoreCase(category).stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice).stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for id: " + id));

        mapToEntity(product, request);
        Product saved = productRepository.save(product);
        return mapToResponse(saved);
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found for id: " + id);
        }
        productRepository.deleteById(id);
    }

    private void mapToEntity(Product product, ProductRequest request) {
        product.setProductName(request.getProductName());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setBrand(request.getBrand());
        product.setDescription(request.getDescription());
    }

    private ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getProductName(),
                product.getCategory(),
                product.getPrice(),
                product.getQuantity(),
                product.getBrand(),
                product.getDescription()
        );
    }
}

