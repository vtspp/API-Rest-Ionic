package com.vtspp.api.ionic.service;

import com.vtspp.api.ionic.dto.CategoryDTO;

import java.util.List;

public interface Services<T> {

    T save (T obj) throws RuntimeException;
    void remove (Integer id) throws RuntimeException;
    List<T> findAll () throws RuntimeException;
    void update (T obj) throws RuntimeException;
    CategoryDTO findOne (Integer id) throws RuntimeException;
}
