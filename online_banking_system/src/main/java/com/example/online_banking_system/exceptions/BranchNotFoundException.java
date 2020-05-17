package com.example.online_banking_system.exceptions;

public class BranchNotFoundException extends RuntimeException{
    public BranchNotFoundException(String message) {
        super(message);
    }
}
