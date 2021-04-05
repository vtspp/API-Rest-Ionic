package com.vtspp.api.ionic.service.templateMethod;

import com.vtspp.api.ionic.service.strategy.EmailService;
import com.vtspp.api.ionic.util.Parameter;
import org.springframework.mail.SimpleMailMessage;

public  interface TemplateMethodEmailService<T extends Class<?>> extends EmailService<T> {

    @Override
     default void senderConfirmation(T obj) {
        SimpleMailMessage simpleMailMessage = prepareSimpleMailMessage(obj);
        senderEmail(simpleMailMessage);
    }

    default SimpleMailMessage prepareSimpleMailMessage(T obj){
        Parameter parameter = new Parameter();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(parameter.getValue("default.sender"));
        return null;
    }
}
