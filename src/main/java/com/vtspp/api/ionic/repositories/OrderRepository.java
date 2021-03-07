package com.vtspp.api.ionic.repositories;

import com.vtspp.api.ionic.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends Repositories<Category, Integer> {
}