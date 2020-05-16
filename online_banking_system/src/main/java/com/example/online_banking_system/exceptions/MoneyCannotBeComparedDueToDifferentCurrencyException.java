package com.example.online_banking_system.exceptions;

import com.example.online_banking_system.pojo.Money;

public class MoneyCannotBeComparedDueToDifferentCurrencyException extends RuntimeException {

  public MoneyCannotBeComparedDueToDifferentCurrencyException(Money m1, Money m2) {
    super(m1 + " cannot be compared to " + m2 + " due to different currencies");
  }
}
