package com.example.online_banking_system.enums;

public enum TransactionStatus {

    SUCCESS("SUCCESS"),
    PENDING("PENDING"),
    FAILED("FAILED");

    private String status;

    TransactionStatus(String status) {
        this.status = status;
    }
}
