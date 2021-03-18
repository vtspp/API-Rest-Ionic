package com.vtspp.api.ionic.service.exceptions.item_order;

import java.io.Serializable;

public class ItemOrderUpdateException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ItemOrderUpdateException(String message) {
        super(message);
    }
}
