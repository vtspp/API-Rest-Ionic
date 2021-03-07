package com.vtspp.api.ionic.util.messages.exceptions.andress;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

public class UtilMessageAndress implements Serializable {
    private static final long serialVersionUID = 1L;

    private static String MESSAGE_ERROR_FIND_ONE_ANDRESS ;
    private static String MESSAGE_ERROR_SAVE_ANDRESS ;
    private static String MESSAGE_ERROR_REMOVE_ANDRESS ;
    private static String MESSAGE_ERROR_UPDATE_ANDRESS ;
    private static String MESSAGE_ERROR_FIND_ALL_ANDRESS;

    @ConfigurationProperties("message.error.findOne.andress")
    public static String getMessageErrorFindOneAndress() {
        return MESSAGE_ERROR_FIND_ONE_ANDRESS;
    }

    @ConfigurationProperties("message.error.save.andress")
    public static String getMessageErrorSaveAndress() {
        return MESSAGE_ERROR_SAVE_ANDRESS;
    }

    @ConfigurationProperties("message.error.remove.andress")
    public static String getMessageErrorRemoveAndress() {
        return MESSAGE_ERROR_REMOVE_ANDRESS;
    }

    @ConfigurationProperties("message.error.update.andress")
    public static String getMessageErrorUpdateAndress() {
        return MESSAGE_ERROR_UPDATE_ANDRESS;
    }

    @ConfigurationProperties("message.error.findAll.andress")
    public static String getMessageErrorFindAllAndress() {
        return MESSAGE_ERROR_FIND_ALL_ANDRESS;
    }

}
