package com.example.online_banking_system.exceptions;

public class BranchNotFoundException extends Exception{
    public BranchNotFoundException(String message) {
        super(message);
    }
}
