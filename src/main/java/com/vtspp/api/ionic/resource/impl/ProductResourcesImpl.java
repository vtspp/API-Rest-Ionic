package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.Product;
import com.vtspp.api.ionic.dto.CategoryDTO;
import com.vtspp.api.ionic.resource.ProductResources;
import com.vtspp.api.ionic.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResourcesImpl implements ProductResources {

    private ProductServiceImpl productService;

    @Autowired
    public ProductResourcesImpl(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Void> save(@RequestBody Product obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> remove(@PathVariable Integer id) {
        productService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody Product obj) {
        productService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CategoryDTO> findOne(Integer id) {
        return null;
    }
}
