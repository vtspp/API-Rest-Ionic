package com.vtspp.api.ionic.util.messages.exceptions.city;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

public class UtilMessageCity implements Serializable {
    private static final long serialVersionUID = 1L;


    private static String MESSAGE_ERROR_FIND_ONE_CITY ;
    private static String MESSAGE_ERROR_SAVE_CITY ;
    private static String MESSAGE_ERROR_REMOVE_CITY ;
    private static String MESSAGE_ERROR_UPDATE_CITY ;
    private static String MESSAGE_ERROR_FIND_ALL_CITY ;


    @ConfigurationProperties("message.error.findOne.city")
    public static String getMessageErrorFindOneCity() {
        return MESSAGE_ERROR_FIND_ONE_CITY;
    }

    @ConfigurationProperties("message.error.save.city")
    public static String getMessageErrorSaveCity() {
        return MESSAGE_ERROR_SAVE_CITY;
    }

    @ConfigurationProperties("message.error.remove.city")
    public static String getMessageErrorRemoveCity() {
        return MESSAGE_ERROR_REMOVE_CITY;
    }

    @ConfigurationProperties("message.error.update.city")
    public static String getMessageErrorUpdateCity() {
        return MESSAGE_ERROR_UPDATE_CITY;
    }

    @ConfigurationProperties("message.error.findAll.city")
    public static String getMessageErrorFindAllCity() {
        return MESSAGE_ERROR_FIND_ALL_CITY;
    }

}
