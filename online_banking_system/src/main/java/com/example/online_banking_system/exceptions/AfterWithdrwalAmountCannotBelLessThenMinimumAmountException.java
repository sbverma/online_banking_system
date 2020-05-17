package com.example.online_banking_system.exceptions;

public class AfterWithdrwalAmountCannotBelLessThenMinimumAmountException extends RuntimeException {

    public AfterWithdrwalAmountCannotBelLessThenMinimumAmountException(String message) {
        super(message);
    }
}
