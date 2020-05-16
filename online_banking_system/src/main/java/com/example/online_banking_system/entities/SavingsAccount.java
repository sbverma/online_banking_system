package com.example.online_banking_system.entities;

import com.example.online_banking_system.Constants;
import com.example.online_banking_system.enums.AccountType;
import com.example.online_banking_system.exceptions.CurrentBalanceShouldBeAtleastEqualToMinBalance;
import com.example.online_banking_system.pojo.DailyWithdrawalLimit;
import com.example.online_banking_system.pojo.Money;

public class SavingsAccount extends Account {

  public SavingsAccount(
      Long accountId,
      Customer customer,
      Money currentBalance,
      DailyWithdrawalLimit dailyWithdrawalLimit) {

    super(
        accountId,
        currentBalance,
        0.0,
        customer,
        Constants.MIN_MONEY_FOR_SAVINGS_ACCOUNT,
        AccountType.CURRENT_ACCOUNT,
        dailyWithdrawalLimit);

    if (this.getCurrentBalance().compareTo(this.getMinimumBalance()) < 0) {
      throw new CurrentBalanceShouldBeAtleastEqualToMinBalance(Constants.MIN_MONEY_FOR_SAVINGS_ACCOUNT);
    }
  }
}
