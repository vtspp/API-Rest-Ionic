package com.vtspp.api.ionic.service.exceptions.category;

import java.io.Serializable;

public class CategoryNotSaveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public CategoryNotSaveException(String message) {
        super(message);
    }
}
