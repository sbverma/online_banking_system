package com.example.online_banking_system.pojo;

import com.example.online_banking_system.enums.Currency;
import com.example.online_banking_system.exceptions.MoneyCannotBeComparedDueToDifferentCurrencyException;
import java.util.HashMap;

public class Money implements Comparable<Money> {
  private Double amount;
  private Currency currency;

  public static Money getSavings() {
    Money m = new Money(10000d);
    return m;
  }

  public static Money getCurrent() {
    Money m = new Money(20000d);
    return m;
  }

  public Money(Double amount) {
    this.amount = amount;
    this.currency = Currency.INR;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  @Override
  public String toString() {
    return "Money{" +
            "amount=" + amount +
            ", currency=" + currency +
            '}';
  }

  @Override
  public int compareTo(Money that) {
    if (this.currency != that.currency) {
      throw new MoneyCannotBeComparedDueToDifferentCurrencyException(this, that);
    }

    if (this.getAmount() < that.getAmount()) {
      return -1;
    } else if (this.getAmount() == that.getAmount()) {
      return 0;
    } else{
      return 1;
    }
  }
}
