package com.example.online_banking_system.exceptions;

public class RejectTransactionException extends Exception{
    public RejectTransactionException(String message) {
        super(message);
    }
}
