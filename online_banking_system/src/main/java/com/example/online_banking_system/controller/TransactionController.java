package com.example.online_banking_system.controller;

import com.example.online_banking_system.entities.Transaction;
import com.example.online_banking_system.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banking-system")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/get-all-transactions/{accountNumber}")
    public List<Transaction> getTransactionHistory(@PathVariable("accountNumber") Long accountNumber) {
        return transactionService.getAllTransaction(accountNumber);
    }

    @GetMapping("/get-mini-statement/{accountNumber}")
    public List<Transaction> getLatestTransactionHistory(@PathVariable("accountNumber") Long accountNumber) {
        return transactionService.getLatestAllTransaction(accountNumber);
    }
}
