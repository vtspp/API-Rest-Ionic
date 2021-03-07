package com.vtspp.api.ionic.service.exceptions.product;

import java.io.Serializable;

public class ProductUpdateException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ProductUpdateException(String message) {
        super(message);
    }
}
