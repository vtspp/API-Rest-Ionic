package com.vtspp.api.ionic.service.exceptions.city;

import java.io.Serializable;

public class CityRemoveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public CityRemoveException(String message) {
        super(message);
    }
}
