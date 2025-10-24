package com.example.usercrud.exception;

import java.time.Instant;
import java.util.List;

public class ApiError {
    private Instant timestamp = Instant.now();
    private int status;
    private String error;
    private List<String> messages;

    public ApiError() {}

    public ApiError(int status, String error, List<String> messages) {
        this.status = status; this.error = error; this.messages = messages;
    }

    // getters/setters
    public Instant getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
    public List<String> getMessages() { return messages; }
    public void setMessages(List<String> messages) { this.messages = messages; }
}
