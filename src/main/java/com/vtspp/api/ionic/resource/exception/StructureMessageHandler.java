package com.vtspp.api.ionic.resource.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StructureMessageHandler implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer status;
    private String message;
    private Long timeStamp;
    private LocalDateTime instant;
    private String path;

    public StructureMessageHandler(Integer status, String message, Long timeStamp, LocalDateTime instant, String path) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.instant = instant;
        this.path = path;
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

    public String getPath() {
        return path;
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

    public void setPath(String path) {
        this.path = path;
    }
}
