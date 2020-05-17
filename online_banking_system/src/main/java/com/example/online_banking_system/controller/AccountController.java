package com.example.online_banking_system.controller;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.exceptions.AccountNotFoundException;
import com.example.online_banking_system.exceptions.AccountTypeIsNotValidException;
import com.example.online_banking_system.exceptions.AfterWithdrwalAmountCannotBelLessThenMinimumAmountException;
import com.example.online_banking_system.exceptions.BranchNotFoundException;
import com.example.online_banking_system.exceptions.ConstraintViolationException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banking-system")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create-account")
    public Account createAccount(@RequestBody CreateAccountRequest createAccountRequest) throws ConstraintViolationException, BranchNotFoundException, AccountTypeIsNotValidException {
        // authenticate
        return accountService.createAccount(createAccountRequest);
    }

    @PostMapping("/deposit-money")
    public Account depositMoney(@RequestBody DepositMoneyRequest depositMoneyRequest) throws AccountNotFoundException, ConstraintViolationException {
        // authenticate
        return accountService.depositMoney(depositMoneyRequest);
    }

    @PostMapping("/withdraw-money")
    public Account depositMoney(@RequestBody WithdrawalMoneyRequest withdrawalMoneyRequest) throws AccountNotFoundException, AfterWithdrwalAmountCannotBelLessThenMinimumAmountException, ConstraintViolationException {
        // authenticate
        return accountService.withdrawalMoney(withdrawalMoneyRequest);
    }

    @GetMapping("/get-account/{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable("accountNumber") Long accountNumber) throws AccountNotFoundException {
        // authenticate
        return accountService.getAccountByAccountNumber(accountNumber);
    }
}
