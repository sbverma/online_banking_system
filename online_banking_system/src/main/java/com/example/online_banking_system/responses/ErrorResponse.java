package com.example.online_banking_system.responses;

public class ErrorResponse {
    String msg;
    Object error;

    public ErrorResponse(String msg, Object error) {
        this.msg = msg;
        this.error = error;
    }
}
