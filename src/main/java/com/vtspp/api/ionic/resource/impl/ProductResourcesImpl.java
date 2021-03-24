package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.Product;
import com.vtspp.api.ionic.dto.ProductDTO;
import com.vtspp.api.ionic.resource.ProductResources;
import com.vtspp.api.ionic.service.exceptions.product.ProductNotFoundException;
import com.vtspp.api.ionic.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
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
    public ResponseEntity<Void> save(Product obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> remove(Integer id) {
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
    public ResponseEntity<Void> update(Product obj) {
        productService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<?> findOne(Integer id) {
        try {
            return ResponseEntity.ok(new ProductDTO(productService.findOne(id)));
        }
        catch (EntityNotFoundException e) {
            throw new ProductNotFoundException(productService.getUtilMessageProduct().getMessageErrorFindOneProduct());
        }
    }

    @Override
    public ResponseEntity<?> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
        Page<Product> productList = productService.findPage(page, linePerPage, direction, orderBy);
        return ResponseEntity.ok(productList);
    }


}
