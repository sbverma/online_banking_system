package com.example.online_banking_system.services;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.entities.Transaction;
import com.example.online_banking_system.enums.TransactionStatus;
import com.example.online_banking_system.enums.TransactionType;
import com.example.online_banking_system.pojo.Money;
import com.example.online_banking_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransaction(Long accountNumber)  {
        List<Transaction> transactions = transactionRepository.getAllTransactionsOfAccount(accountNumber);
        return transactions;
    }

    public List<Transaction> getLatestAllTransaction(Long accountNumber) {
        List<Transaction> transactions = transactionRepository.getLastTenTransactionsOfAccount(accountNumber);
        return transactions;
    }

    public Transaction createTransaction(Account account, TransactionType transactionType, Money withdrawalAmount, TransactionStatus transactionStatus) {

        Transaction transaction =  new Transaction(withdrawalAmount, transactionType, transactionStatus, account);
        transaction = transactionRepository.saveTxn(transaction);
        return transaction;
    }
}
