package com.vtspp.api.ionic.util.messages.exceptions.category;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

public class UtilMessageCategory implements Serializable {
    private static final long serialVersionUID = 1L;


    private static String MESSAGE_ERROR_FIND_ONE_CATEGORY ;
    private static String MESSAGE_ERROR_SAVE_CATEGORY ;
    private static String MESSAGE_ERROR_REMOVE_CATEGORY ;
    private static String MESSAGE_ERROR_UPDATE_CATEGORY ;
    private static String MESSAGE_ERROR_FIND_ALL_CATEGORY ;


    @ConfigurationProperties("message.error.findOne.category")
    public static String getMessageErrorFindOneCategory() {
        return MESSAGE_ERROR_FIND_ONE_CATEGORY;
    }

    @ConfigurationProperties("message.error.save.category")
    public static String getMessageErrorSaveCategory() {
        return MESSAGE_ERROR_SAVE_CATEGORY;
    }

    @ConfigurationProperties("message.error.remove.category")
    public static String getMessageErrorRemoveCategory() {
        return MESSAGE_ERROR_REMOVE_CATEGORY;
    }

    @ConfigurationProperties("message.error.update.category")
    public static String getMessageErrorUpdateCategory() {
        return MESSAGE_ERROR_UPDATE_CATEGORY;
    }

    @ConfigurationProperties("message.error.findAll.category")
    public static String getMessageErrorFindAllCategory() {
        return MESSAGE_ERROR_FIND_ALL_CATEGORY;
    }

}
