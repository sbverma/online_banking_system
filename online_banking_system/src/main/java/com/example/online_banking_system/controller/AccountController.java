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
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        // authenticate
        accountService.createAccount(createAccountRequest);
        return null;
    }

    @PostMapping("/deposit-money")
    public DepositMoneyResponse depositMoney(DepositMoneyRequest depositMoneyRequest) {
        // authenticate
        accountService.depositMoney(depositMoneyRequest);
        return null;
    }

    @PostMapping("/withdraw-money")
    public WithdrawalMoneyResponse depositMoney(WithdrawalMoneyRequest withdrawalMoneyRequest) {
        // authenticate
        accountService.withdrawalMoney(withdrawalMoneyRequest);
        return null;
    }

    @GetMapping("/get-account/{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable("accountNumber") Long accountNumber) {
        // authenticate
        accountService.getAccountByAccountNumber(accountNumber);
        return null;
    }
}
