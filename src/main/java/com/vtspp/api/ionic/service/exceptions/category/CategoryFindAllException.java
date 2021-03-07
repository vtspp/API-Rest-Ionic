package com.vtspp.api.ionic.service.exceptions.category;

import java.io.Serializable;

public class CategoryFindAllException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public CategoryFindAllException(String message) {
        super(message);
    }
}
