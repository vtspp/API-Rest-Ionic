package com.vtspp.api.ionic.util.messages.exceptions.product;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

public class UtilMessageProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    private static String MESSAGE_ERROR_FIND_ONE_PRODUCT ;
    private static String MESSAGE_ERROR_SAVE_PRODUCT ;
    private static String MESSAGE_ERROR_REMOVE_PRODUCT ;
    private static String MESSAGE_ERROR_UPDATE_PRODUCT ;
    private static String MESSAGE_ERROR_FIND_ALL_PRODUCT;

    @ConfigurationProperties("message.error.findOne.product")
    public static String getMessageErrorFindOneProduct() {
        return MESSAGE_ERROR_FIND_ONE_PRODUCT;
    }

    @ConfigurationProperties("message.error.save.product")
    public static String getMessageErrorSaveProduct() {
        return MESSAGE_ERROR_SAVE_PRODUCT;
    }

    @ConfigurationProperties("message.error.remove.product")
    public static String getMessageErrorRemoveProduct() {
        return MESSAGE_ERROR_REMOVE_PRODUCT;
    }

    @ConfigurationProperties("message.error.update.product")
    public static String getMessageErrorUpdateProduct() {
        return MESSAGE_ERROR_UPDATE_PRODUCT;
    }

    @ConfigurationProperties("message.error.findAll.product")
    public static String getMessageErrorFindAllProduct() {
        return MESSAGE_ERROR_FIND_ALL_PRODUCT;
    }

}
