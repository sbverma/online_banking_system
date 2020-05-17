package com.example.online_banking_system.exceptions;

public class AccountTypeIsNotValidException extends Exception{
    public AccountTypeIsNotValidException(String message) {
        super(message);
    }
}
