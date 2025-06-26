package com.gaurav.productcatalog.service;

import com.gaurav.productcatalog.dto.ProductDTO;
import com.gaurav.productcatalog.entity.Product;
import com.gaurav.productcatalog.mapper.ProductMapper;
import com.gaurav.productcatalog.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(value = "featuredProducts")
    public List<ProductDTO> getFeaturedProducts() {
        System.out.println("Fetching from DB (no cache)...");
        return productRepository.findByFeaturedTrue()
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @CacheEvict(value = "featuredProducts", allEntries = true)
    public void evictFeaturedProductsCache() {
        System.out.println("Redis cache for featuredProducts cleared.");
    }
}

