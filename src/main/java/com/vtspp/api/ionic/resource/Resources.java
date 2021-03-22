package com.vtspp.api.ionic.resource;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Resources <T>{

    ResponseEntity<Void> save (T obj);
    ResponseEntity<Void> remove (Integer id);
    ResponseEntity<List<T>> findAll();
    ResponseEntity<Void> update (T obj);
    ResponseEntity<?> findOne (Integer id);
    ResponseEntity<?> findPage (Integer page, Integer linePerPage, String orderBy, String direction);
}
