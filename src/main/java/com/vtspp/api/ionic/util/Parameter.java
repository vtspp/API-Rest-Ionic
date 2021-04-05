package com.vtspp.api.ionic.util;

import java.util.Properties;

public class Parameter extends Properties {

    public String getValue(String value){
        return this.getProperty(value);
    }
}
