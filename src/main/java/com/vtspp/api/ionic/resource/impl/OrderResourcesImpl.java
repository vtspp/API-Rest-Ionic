package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.Order;
import com.vtspp.api.ionic.resource.OrderResources;
import com.vtspp.api.ionic.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResourcesImpl implements OrderResources {

    private OrderServiceImpl orderService;

    @Autowired
    public OrderResourcesImpl(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<Void> save(Order obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(orderService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> remove(Integer id) {
        orderService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @Override
    public ResponseEntity<Void> update(Order obj) {
        orderService.update(obj);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> findOne(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        return null;
    }

}
