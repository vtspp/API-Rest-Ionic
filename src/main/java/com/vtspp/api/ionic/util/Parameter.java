package com.vtspp.api.ionic.util;

import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class Parameter extends Properties {

    public String getValue(String value){
        return this.getProperty(value);
    }
}
