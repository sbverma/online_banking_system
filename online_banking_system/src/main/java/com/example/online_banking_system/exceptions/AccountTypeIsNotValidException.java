package com.example.online_banking_system.exceptions;

public class AccountTypeIsNotValidException extends RuntimeException{
    public AccountTypeIsNotValidException(String message) {
        super(message);
    }
}
