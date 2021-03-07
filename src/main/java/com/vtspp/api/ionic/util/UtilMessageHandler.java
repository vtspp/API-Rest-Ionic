package com.vtspp.api.ionic.util;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UtilMessageHandler implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer status;
    private String message;
    private Long timeStamp;
    private LocalDateTime instant;

    public UtilMessageHandler(Integer status, String message, Long timeStamp, LocalDateTime instant) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.instant = instant;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public LocalDateTime getInstant() {
        return instant;
    }

    public void setInstant(LocalDateTime instant) {
        this.instant = instant;
    }
}
