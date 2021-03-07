package com.vtspp.api.ionic.util.messages.exceptions.telephone;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

public class UtilMessageTelephone implements Serializable {
    private static final long serialVersionUID = 1L;


    private static String MESSAGE_ERROR_FIND_ONE_TELEPHONE ;
    private static String MESSAGE_ERROR_SAVE_TELEPHONE ;
    private static String MESSAGE_ERROR_REMOVE_TELEPHONE ;
    private static String MESSAGE_ERROR_UPDATE_TELEPHONE ;
    private static String MESSAGE_ERROR_FIND_ALL_TELEPHONE ;


    @ConfigurationProperties("message.error.findOne.telephone")
    public static String getMessageErrorFindOneTelephone() {
        return MESSAGE_ERROR_FIND_ONE_TELEPHONE;
    }

    @ConfigurationProperties("message.error.save.telephone")
    public static String getMessageErrorSaveTelephone() {
        return MESSAGE_ERROR_SAVE_TELEPHONE;
    }

    @ConfigurationProperties("message.error.remove.telephone")
    public static String getMessageErrorRemoveTelephone() {
        return MESSAGE_ERROR_REMOVE_TELEPHONE;
    }

    @ConfigurationProperties("message.error.update.telephone")
    public static String getMessageErrorUpdateTelephone() {
        return MESSAGE_ERROR_UPDATE_TELEPHONE;
    }

    @ConfigurationProperties("message.error.findAll.telephone")
    public static String getMessageErrorFindAllTelephone() {
        return MESSAGE_ERROR_FIND_ALL_TELEPHONE;
    }

}
