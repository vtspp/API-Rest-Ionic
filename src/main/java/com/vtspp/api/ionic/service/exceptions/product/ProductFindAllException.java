package com.vtspp.api.ionic.service.exceptions.product;

import java.io.Serializable;

public class ProductFindAllException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ProductFindAllException(String message) {
        super(message);
    }
}
