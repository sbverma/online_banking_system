package com.example.online_banking_system.validators;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.exceptions.AfterWithdrwalAmountCannotBelLessThenMinimumAmountException;
import com.example.online_banking_system.pojo.Money;
import org.springframework.stereotype.Component;

@Component
public class MinimumAmountValidator implements Validator {
    public boolean validate(Account account, Money withdrawalMoney) throws AfterWithdrwalAmountCannotBelLessThenMinimumAmountException {
        if (account.getCurrentBalance().getAmount() - withdrawalMoney.getAmount() < account.getAccountType().getMinimumAmount().getAmount()) {
            throw new AfterWithdrwalAmountCannotBelLessThenMinimumAmountException("Current Amount " + account.getCurrentBalance().getAmount() + " - withdrawal Amount " + withdrawalMoney.getAmount() + " is less then minimum balance " + account.getAccountType().getMinimumAmount().getAmount());
        }
        return true;
    }
}
