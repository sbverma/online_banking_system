package com.example.online_banking_system.validators;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.pojo.Money;
import com.example.online_banking_system.utils.DateUtil;

import java.time.LocalDateTime;

public class DailyWithdrawalLimitValidator implements Validator {
    public boolean validate(Account account, Money withrawalMoney) {
        if(!DateUtil.getDateAsString(LocalDateTime.now()).equals(account.getDailyWithdrawalLimit().getDate()))  {
            return false;
        }
        if (account.getDailyWithdrawalLimit().getAmountDebit().getAmount() + withrawalMoney.getAmount() <= account.getMinimumBalance().getAmount() ) {
            return true;
        }
        return false;
    }
}
