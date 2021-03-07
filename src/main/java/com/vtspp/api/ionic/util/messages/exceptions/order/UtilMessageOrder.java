package com.vtspp.api.ionic.util.messages.exceptions.order;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

public class UtilMessageOrder implements Serializable {
    private static final long serialVersionUID = 1L;


    private static String MESSAGE_ERROR_FIND_ONE_ORDER ;
    private static String MESSAGE_ERROR_SAVE_ORDER ;
    private static String MESSAGE_ERROR_REMOVE_ORDER ;
    private static String MESSAGE_ERROR_UPDATE_ORDER ;
    private static String MESSAGE_ERROR_FIND_ALL_ORDER ;


    @ConfigurationProperties("message.error.findOne.order")
    public static String getMessageErrorFindOneOrder() {
        return MESSAGE_ERROR_FIND_ONE_ORDER;
    }

    @ConfigurationProperties("message.error.save.order")
    public static String getMessageErrorSaveOrder() {
        return MESSAGE_ERROR_SAVE_ORDER;
    }

    @ConfigurationProperties("message.error.remove.order")
    public static String getMessageErrorRemoveOrder() {
        return MESSAGE_ERROR_REMOVE_ORDER;
    }

    @ConfigurationProperties("message.error.update.order")
    public static String getMessageErrorUpdateOrder() {
        return MESSAGE_ERROR_UPDATE_ORDER;
    }

    @ConfigurationProperties("message.error.findAll.order")
    public static String getMessageErrorFindAllOrder() {
        return MESSAGE_ERROR_FIND_ALL_ORDER;
    }

}
