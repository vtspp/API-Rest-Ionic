package com.vtspp.api.ionic.resource.impl;

import com.vtspp.api.ionic.domain.Andress;
import com.vtspp.api.ionic.dto.CategoryDTO;
import com.vtspp.api.ionic.resource.AndressResources;
import com.vtspp.api.ionic.service.impl.AndressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/andresses")
public class AndressResourcesImpl implements AndressResources {

    private AndressServiceImpl andressService;

    @Autowired
    public AndressResourcesImpl(AndressServiceImpl andressService) {
        this.andressService = andressService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Void> save(@RequestBody Andress obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(andressService.save(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> remove(@PathVariable Integer id) {
        andressService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Andress>> findAll() {
        return ResponseEntity.ok(andressService.findAll());
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody Andress obj) {
        andressService.update(obj);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CategoryDTO> findOne(Integer id) {
        return null;
    }
}
