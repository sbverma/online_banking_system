package com.example.online_banking_system.responses;

public class ErrorResponse {
    String msg;
    Object error;

    public ErrorResponse(String msg, Object error) {
        this.msg = msg;
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
