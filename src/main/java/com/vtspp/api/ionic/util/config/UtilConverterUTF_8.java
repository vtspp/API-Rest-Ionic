package com.vtspp.api.ionic.util.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:messages/application-message.properties", encoding = "UTF-8")
public class UtilConverterUTF_8 {
}
