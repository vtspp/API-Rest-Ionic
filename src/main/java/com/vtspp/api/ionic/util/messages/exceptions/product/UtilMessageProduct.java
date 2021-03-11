package com.vtspp.api.ionic.util.messages.exceptions.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UtilMessageProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    @Value(value = "${message.error.findOne.product}")
    private String MESSAGE_ERROR_FIND_ONE_PRODUCT ;

    @Value(value = "${message.error.save.product}")
    private String MESSAGE_ERROR_SAVE_PRODUCT ;

    @Value(value = "${message.error.remove.product}")
    private String MESSAGE_ERROR_REMOVE_PRODUCT ;

    @Value(value = "${message.error.update.product}")
    private String MESSAGE_ERROR_UPDATE_PRODUCT ;

    @Value(value = "${message.error.findAll.product}")
    private String MESSAGE_ERROR_FIND_ALL_PRODUCT;

    public String getMessageErrorFindOneProduct() {
        return MESSAGE_ERROR_FIND_ONE_PRODUCT;
    }

    public String getMessageErrorSaveProduct() {
        return MESSAGE_ERROR_SAVE_PRODUCT;
    }

    public String getMessageErrorRemoveProduct() {
        return MESSAGE_ERROR_REMOVE_PRODUCT;
    }

    public String getMessageErrorUpdateProduct() {
        return MESSAGE_ERROR_UPDATE_PRODUCT;
    }

    public String getMessageErrorFindAllProduct() {
        return MESSAGE_ERROR_FIND_ALL_PRODUCT;
    }

}
