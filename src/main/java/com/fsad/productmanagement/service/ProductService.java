package com.fsad.productmanagement.service;

import com.fsad.productmanagement.dto.ProductRequest;
import com.fsad.productmanagement.dto.ProductResponse;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    ProductResponse create(ProductRequest request);

    List<ProductResponse> getAll();

    ProductResponse getById(Long id);

    List<ProductResponse> getByCategory(String category);

    List<ProductResponse> getByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

    ProductResponse update(Long id, ProductRequest request);

    void delete(Long id);
}

