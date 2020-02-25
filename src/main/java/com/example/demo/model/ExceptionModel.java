package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class ExceptionModel {
    String status,message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
