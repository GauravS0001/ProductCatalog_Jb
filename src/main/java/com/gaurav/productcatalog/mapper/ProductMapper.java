package com.gaurav.productcatalog.mapper;

import com.gaurav.productcatalog.dto.ProductDTO;
import com.gaurav.productcatalog.entity.Product;

public class ProductMapper {

    public static ProductDTO toDto(Product product) {
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getCategory(),
            product.getPrice(),
            product.getImageUrl(),
            product.getLastUpdated()
        );
    }
}
