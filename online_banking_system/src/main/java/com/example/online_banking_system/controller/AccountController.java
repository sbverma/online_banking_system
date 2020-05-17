package com.example.online_banking_system.controller;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.requests.CreateAccountRequest;
import com.example.online_banking_system.requests.DepositMoneyRequest;
import com.example.online_banking_system.requests.WithdrawalMoneyRequest;
import com.example.online_banking_system.responses.CreateAccountResponse;
import com.example.online_banking_system.responses.DepositMoneyResponse;
import com.example.online_banking_system.responses.WithdrawalMoneyResponse;
import com.example.online_banking_system.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banking-system")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create-account")
    public Account createAccount(CreateAccountRequest createAccountRequest) {
        // authenticate
        return accountService.createAccount(createAccountRequest);
    }

    @PostMapping("/deposit-money")
    public Account depositMoney(DepositMoneyRequest depositMoneyRequest) {
        // authenticate
        return accountService.depositMoney(depositMoneyRequest);
    }

    @PostMapping("/withdraw-money")
    public Account depositMoney(WithdrawalMoneyRequest withdrawalMoneyRequest) {
        // authenticate
        return accountService.withdrawalMoney(withdrawalMoneyRequest);
    }

    @GetMapping("/get-account/{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable("accountNumber") Long accountNumber) {
        // authenticate
        return accountService.getAccountByAccountNumber(accountNumber);
    }
}
