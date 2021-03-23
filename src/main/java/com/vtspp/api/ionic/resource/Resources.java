package com.vtspp.api.ionic.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface Resources <T>{

    @PostMapping ResponseEntity<Void> save (@RequestBody T obj);
    @DeleteMapping("/{id}") ResponseEntity<Void> remove (@PathVariable Integer id);
    @GetMapping ResponseEntity<List<T>> findAll();
    @PutMapping ResponseEntity<Void> update (@RequestBody T obj);
    @GetMapping("/{id}") ResponseEntity<?> findOne (@PathVariable Integer id);
    @GetMapping("/page") ResponseEntity<?> findPage (@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "24") Integer linePerPage, @RequestParam(defaultValue = "ASC") String direction, @RequestParam(defaultValue = "id") String orderBy);
}
