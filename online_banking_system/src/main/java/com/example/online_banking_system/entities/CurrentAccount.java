package com.example.online_banking_system.entities;

import com.example.online_banking_system.Constants;
import com.example.online_banking_system.enums.AccountType;
import com.example.online_banking_system.exceptions.CurrentBalanceShouldBeAtleastEqualToMinBalance;
import com.example.online_banking_system.pojo.DailyWithdrawalLimit;
import com.example.online_banking_system.pojo.Money;


public class CurrentAccount extends Account {

  public CurrentAccount(
      Customer customer,
      Money currentBalance,
      Branch branch) {
    super(
        currentBalance,
        customer,
        AccountType.CURRENT_ACCOUNT,
            branch);
  }

  public CurrentAccount(Account account) {
    super(account);
  }
}
