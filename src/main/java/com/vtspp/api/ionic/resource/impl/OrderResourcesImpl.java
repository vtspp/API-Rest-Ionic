package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.Category;
import com.vtspp.api.ionic.resource.CategoryResources;
import com.vtspp.api.ionic.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class OrderResourcesImpl implements CategoryResources {

    private CategoryServiceImpl categoryService;

    @Autowired
    public OrderResourcesImpl(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Void> save(@RequestBody Category obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(categoryService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> remove(@PathVariable Integer id) {
        categoryService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody Category obj) {
        categoryService.update(obj);
        return ResponseEntity.ok().build();
    }
}
