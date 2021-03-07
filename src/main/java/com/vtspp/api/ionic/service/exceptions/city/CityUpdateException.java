package com.vtspp.api.ionic.service.exceptions.city;

import java.io.Serializable;

public class CityUpdateException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public CityUpdateException(String message) {
        super(message);
    }
}
