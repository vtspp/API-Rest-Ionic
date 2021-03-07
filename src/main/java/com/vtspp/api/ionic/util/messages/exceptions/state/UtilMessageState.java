package com.vtspp.api.ionic.util.messages.exceptions.state;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

public class UtilMessageState implements Serializable {
    private static final long serialVersionUID = 1L;


    private static String MESSAGE_ERROR_FIND_ONE_STATE ;
    private static String MESSAGE_ERROR_SAVE_STATE ;
    private static String MESSAGE_ERROR_REMOVE_STATE ;
    private static String MESSAGE_ERROR_UPDATE_STATE ;
    private static String MESSAGE_ERROR_FIND_ALL_STATE ;


    @ConfigurationProperties("message.error.findOne.state")
    public static String getMessageErrorFindOneState() {
        return MESSAGE_ERROR_FIND_ONE_STATE;
    }

    @ConfigurationProperties("message.error.save.state")
    public static String getMessageErrorSaveState() {
        return MESSAGE_ERROR_SAVE_STATE;
    }

    @ConfigurationProperties("message.error.remove.state")
    public static String getMessageErrorRemoveState() {
        return MESSAGE_ERROR_REMOVE_STATE;
    }

    @ConfigurationProperties("message.error.update.state")
    public static String getMessageErrorUpdateState() {
        return MESSAGE_ERROR_UPDATE_STATE;
    }

    @ConfigurationProperties("message.error.findAll.state")
    public static String getMessageErrorFindAllState() {
        return MESSAGE_ERROR_FIND_ALL_STATE;
    }

}
