package com.vtspp.api.ionic.repositories;

import com.vtspp.api.ionic.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends Repositories<Order, Integer> {
}