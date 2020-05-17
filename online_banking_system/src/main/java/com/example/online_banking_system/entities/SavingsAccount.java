package com.example.online_banking_system.entities;

import com.example.online_banking_system.Constants;
import com.example.online_banking_system.enums.AccountType;
import com.example.online_banking_system.exceptions.CurrentBalanceShouldBeAtleastEqualToMinBalance;
import com.example.online_banking_system.pojo.DailyWithdrawalLimit;
import com.example.online_banking_system.pojo.Money;

public class SavingsAccount extends Account {

  public SavingsAccount(
      Customer customer,
      Money currentBalance) {

    super(
        currentBalance,
        customer,
        AccountType.SAVINGS_ACCOUNT);
  }
}
