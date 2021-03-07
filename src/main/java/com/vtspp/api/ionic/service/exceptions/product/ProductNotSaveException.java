package com.vtspp.api.ionic.service.exceptions.product;

import java.io.Serializable;

public class ProductNotSaveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ProductNotSaveException(String message) {
        super(message);
    }
}
