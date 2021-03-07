package com.vtspp.api.ionic.service;

import java.util.List;

public interface Services<T> {

    T save (T obj);
    void remove (Integer id);
    List<T> findAll ();
    void update (T obj);
}
