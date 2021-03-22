package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.ItemOrder;
import com.vtspp.api.ionic.resource.ItemOrderResources;
import com.vtspp.api.ionic.service.impl.ItemOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/item_orders")
public class ItemOrderResourcesImpl implements ItemOrderResources {

    private ItemOrderServiceImpl itemOrderService;

    @Autowired
    public ItemOrderResourcesImpl(ItemOrderServiceImpl itemOrderService) {
        this.itemOrderService = itemOrderService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Void> save(@RequestBody ItemOrder obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(itemOrderService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> remove(@PathVariable Integer id) {
        itemOrderService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ItemOrder>> findAll() {
        return ResponseEntity.ok(itemOrderService.findAll());
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody ItemOrder obj) {
        itemOrderService.update(obj);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> findOne(Integer id) {
        return null;
    }
}
