package com.vtspp.api.ionic.service.exceptions.item_order;

import java.io.Serializable;

public class ItemOrderFindAllException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ItemOrderFindAllException(String message) {
        super(message);
    }
}
