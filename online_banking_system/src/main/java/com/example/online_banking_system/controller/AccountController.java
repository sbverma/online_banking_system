package com.example.online_banking_system.controller;

import com.example.online_banking_system.requests.CreateAccountRequest;
import com.example.online_banking_system.requests.DepositMoneyRequest;
import com.example.online_banking_system.requests.WithdrawalMoneyRequest;
import com.example.online_banking_system.responses.CreateAccountResponse;
import com.example.online_banking_system.responses.DepositMoneyResponse;
import com.example.online_banking_system.responses.WithdrawalMoneyResponse;
import com.example.online_banking_system.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        // authenticate
        accountService.createAccount(createAccountRequest);
        return null;
    }

    @PostMapping("/depositMoney")
    public DepositMoneyResponse depositMoney(DepositMoneyRequest depositMoneyRequest) {
        // authenticate
        accountService.depositMoney(depositMoneyRequest);
        return null;
    }

    @PostMapping("/withdrawMoney")
    public WithdrawalMoneyResponse depositMoney(WithdrawalMoneyRequest withdrawalMoneyRequest) {
        // authenticate
        accountService.withdrawalMoney(withdrawalMoneyRequest);
        return null;
    }


}
