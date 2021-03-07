package com.vtspp.api.ionic.service.exceptions.city;

import java.io.Serializable;

public class CityNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public CityNotFoundException(String message) {
        super(message);
    }
}
