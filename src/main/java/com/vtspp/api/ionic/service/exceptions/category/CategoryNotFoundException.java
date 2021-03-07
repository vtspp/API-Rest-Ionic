package com.vtspp.api.ionic.service.exceptions.category;

import java.io.Serializable;

public class CategoryNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
