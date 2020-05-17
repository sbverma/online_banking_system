package com.example.online_banking_system.entities;

import com.example.online_banking_system.Constants;
import com.example.online_banking_system.enums.AccountType;
import com.example.online_banking_system.exceptions.CurrentBalanceShouldBeAtleastEqualToMinBalance;
import com.example.online_banking_system.pojo.DailyWithdrawalLimit;
import com.example.online_banking_system.pojo.Money;

public class CurrentAccount extends Account {

  public CurrentAccount(
      Long accountId,
      Customer customer,
      Money currentBalance) {
    super(
        accountId,
        currentBalance,
        customer,
        AccountType.CURRENT_ACCOUNT);
  }
}
