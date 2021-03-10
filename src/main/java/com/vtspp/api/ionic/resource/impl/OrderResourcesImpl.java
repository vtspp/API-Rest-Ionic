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

    @PostMapping
    @Override
    public ResponseEntity<Void> save(@RequestBody Order obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(orderService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> remove(@PathVariable Integer id) {
        orderService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody Order obj) {
        orderService.update(obj);
        return ResponseEntity.ok().build();
    }
}
