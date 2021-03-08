package com.vtspp.api.ionic.util;

public class Check {

    public static <T> boolean isNull(T value) {
        if(value == null) {
            return true;
        }
        return false;
    }
}
