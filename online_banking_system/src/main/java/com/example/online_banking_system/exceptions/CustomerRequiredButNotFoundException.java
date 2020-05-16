package com.example.online_banking_system.exceptions;

public class CustomerRequiredButNotFoundException extends RuntimeException {
  public CustomerRequiredButNotFoundException() {
    super("Customer login required for proceeding further..Kindly login first..");
  }
}
