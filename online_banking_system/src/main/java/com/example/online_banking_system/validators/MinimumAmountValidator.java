package com.example.online_banking_system.validators;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.pojo.Money;

public class MinimumAmountValidator implements Validator {
    public boolean validate(Account account, Money withrawalMoney) {
        if (account.getCurrentBalance().getAmount() - withrawalMoney.getAmount() >= account.getMinimumBalance().getAmount() ) {
            return true;
        }
        return false;
    }
}
