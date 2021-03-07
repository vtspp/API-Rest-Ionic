package com.vtspp.api.ionic.repositories;

import com.vtspp.api.ionic.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends Repositories<Product, Integer> {
}