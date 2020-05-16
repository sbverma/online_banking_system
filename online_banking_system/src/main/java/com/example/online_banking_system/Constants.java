package com.example.online_banking_system;

import com.example.online_banking_system.pojo.Money;

public class Constants {

  public static Money MIN_MONEY_FOR_CURRENT_ACCOUNT = new Money(20000d);
  public static Money MIN_MONEY_FOR_SAVINGS_ACCOUNT = new Money(10000d);

  public static Double INTEREST_RATE_FOR_CURENNT_ACCOUNT = 0d;
  public static Double INTEREST_RATE_FOR_SAVINGS_ACCOUNT = 4.5d;

}
