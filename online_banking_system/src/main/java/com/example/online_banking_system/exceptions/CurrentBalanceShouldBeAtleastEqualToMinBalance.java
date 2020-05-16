package com.example.online_banking_system.exceptions;

import com.example.online_banking_system.pojo.Money;

public class CurrentBalanceShouldBeAtleastEqualToMinBalance extends RuntimeException {

  public CurrentBalanceShouldBeAtleastEqualToMinBalance(Money money) {
    super("Current balance should atleast be equal to min balance of " + money.getCurrency() + " " + money.getAmount());
  }
}
