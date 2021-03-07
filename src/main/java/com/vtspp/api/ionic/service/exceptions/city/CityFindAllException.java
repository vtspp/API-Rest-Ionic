package com.vtspp.api.ionic.service.exceptions.city;

import java.io.Serializable;

public class CityFindAllException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public CityFindAllException(String message) {
        super(message);
    }
}
