package com.fsad.productmanagement.controller;

import com.fsad.productmanagement.dto.ProductRequest;
import com.fsad.productmanagement.dto.ProductResponse;
import com.fsad.productmanagement.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addProduct(@Valid @RequestBody ProductRequest request) {
        return productService.create(request);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping("/by-category")
    public List<ProductResponse> getByCategory(@RequestParam String category) {
        return productService.getByCategory(category);
    }

    @GetMapping("/by-price-range")
    public List<ProductResponse> getByPriceRange(
            @RequestParam @Min(value = 0, message = "minPrice must be >= 0") BigDecimal minPrice,
            @RequestParam @Min(value = 0, message = "maxPrice must be >= 0") BigDecimal maxPrice
    ) {
        return productService.getByPriceRange(minPrice, maxPrice);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequest request) {
        return productService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}

