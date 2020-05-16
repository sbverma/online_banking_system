package com.example.online_banking_system.exceptions;

public class ConstraintViolationException extends RuntimeException {

  public ConstraintViolationException(String message) {
    super(message);
  }
}
