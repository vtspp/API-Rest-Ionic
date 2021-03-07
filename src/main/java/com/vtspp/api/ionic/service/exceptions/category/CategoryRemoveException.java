package com.vtspp.api.ionic.service.exceptions.category;

import java.io.Serializable;

public class CategoryRemoveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public CategoryRemoveException(String message) {
        super(message);
    }
}
