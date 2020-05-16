package com.example.online_banking_system.validators;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.pojo.Money;

public interface Validator {
    boolean validate(Account account, Money money);
}
