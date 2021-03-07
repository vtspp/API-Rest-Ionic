package com.vtspp.api.ionic.service.exceptions.product;

import java.io.Serializable;

public class ProductRemoveException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ProductRemoveException(String message) {
        super(message);
    }
}
