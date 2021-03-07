package com.vtspp.api.ionic.service.exceptions.city;

import java.io.Serializable;

public class CityNotSaveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public CityNotSaveException(String message) {
        super(message);
    }
}
