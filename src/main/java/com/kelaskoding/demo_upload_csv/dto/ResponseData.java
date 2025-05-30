package com.kelaskoding.demo_upload_csv.dto;

import java.util.ArrayList;
import java.util.List;


public class ResponseData {
    private boolean status;
    private List<String> messages = new ArrayList<>();
    private Object payload;

    public ResponseData() {
    }

    public ResponseData(boolean status, List<String> messages, Object payload) {
        this.status = status;
        this.messages = messages;
        this.payload = payload;
    }

    // getters and setters
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
