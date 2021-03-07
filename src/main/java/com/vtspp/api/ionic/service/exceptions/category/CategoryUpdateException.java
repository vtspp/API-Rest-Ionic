package com.vtspp.api.ionic.service.exceptions.category;

import java.io.Serializable;

public class CategoryUpdateException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public CategoryUpdateException(String message) {
        super(message);
    }
}
