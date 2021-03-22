package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.Category;
import com.vtspp.api.ionic.dto.CategoryDTO;
import com.vtspp.api.ionic.resource.CategoryResources;
import com.vtspp.api.ionic.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResourcesImpl implements CategoryResources {

    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryResourcesImpl(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<Void> save(Category obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(categoryService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<Void> remove(Integer id) {
        categoryService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @Override
    public ResponseEntity<Void> update(Category obj) {
        categoryService.update(obj);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> findOne(Integer id) {
        return ResponseEntity.ok(new CategoryDTO(categoryService.findOne(id)));
    }

    @Override
    public ResponseEntity<Page<Category>> findPage( Integer page, Integer linePerPage, String direction, String orderBy) {
        Page<Category> list = categoryService.findPage(page, linePerPage, direction, orderBy);
        return ResponseEntity.ok(list);
    }
}
