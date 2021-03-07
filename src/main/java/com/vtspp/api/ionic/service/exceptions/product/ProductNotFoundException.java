package com.vtspp.api.ionic.service.exceptions.product;

import java.io.Serializable;

public class ProductNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(String message) {
        super(message);
    }
}
