package com.vtspp.api.ionic.service;

import java.util.List;

public interface Services<T> {

    T save (T obj) throws RuntimeException;
    void remove (Integer id) throws RuntimeException;
    List<T> findAll () throws RuntimeException;
    void update (T obj) throws RuntimeException;
}
