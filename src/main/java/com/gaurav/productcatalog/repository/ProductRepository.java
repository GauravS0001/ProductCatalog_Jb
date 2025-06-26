package com.gaurav.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.productcatalog.entity.Product;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	 List<Product> findByFeaturedTrue();
}
