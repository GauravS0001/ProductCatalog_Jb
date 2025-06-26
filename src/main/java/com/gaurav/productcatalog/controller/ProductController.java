package com.gaurav.productcatalog.controller;

import com.gaurav.productcatalog.dto.ProductDTO;
import com.gaurav.productcatalog.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET /api/products/featured
    @GetMapping("/featured")
    public ResponseEntity<List<ProductDTO>> getFeaturedProducts() {
        List<ProductDTO> products = productService.getFeaturedProducts();
        return ResponseEntity.ok(products);
    }

    // POST /api/products/featured/refresh
    @PostMapping("/featured/refresh")
    public ResponseEntity<String> refreshFeaturedProductsCache() {
        productService.evictFeaturedProductsCache();
        return ResponseEntity.ok("Featured product cache refreshed successfully.");
    }
}

