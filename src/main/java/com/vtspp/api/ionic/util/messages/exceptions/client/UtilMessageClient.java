package com.vtspp.api.ionic.util.messages.exceptions.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

public class UtilMessageClient implements Serializable {
    private static final long serialVersionUID = 1L;


    private static String MESSAGE_ERROR_FIND_ONE_CLIENT ;
    private static String MESSAGE_ERROR_SAVE_CLIENT ;
    private static String MESSAGE_ERROR_REMOVE_CLIENT ;
    private static String MESSAGE_ERROR_UPDATE_CLIENT ;
    private static String MESSAGE_ERROR_FIND_ALL_CLIENT ;


    @ConfigurationProperties("message.error.findOne.client")
    public static String getMessageErrorFindOneClient() {
        return MESSAGE_ERROR_FIND_ONE_CLIENT;
    }

    @ConfigurationProperties("message.error.save.client")
    public static String getMessageErrorSaveClient() {
        return MESSAGE_ERROR_SAVE_CLIENT;
    }

    @ConfigurationProperties("message.error.remove.client")
    public static String getMessageErrorRemoveClient() {
        return MESSAGE_ERROR_REMOVE_CLIENT;
    }

    @ConfigurationProperties("message.error.update.client")
    public static String getMessageErrorUpdateClient() {
        return MESSAGE_ERROR_UPDATE_CLIENT;
    }

    @ConfigurationProperties("message.error.findAll.client")
    public static String getMessageErrorFindAllClient() {
        return MESSAGE_ERROR_FIND_ALL_CLIENT;
    }

}
