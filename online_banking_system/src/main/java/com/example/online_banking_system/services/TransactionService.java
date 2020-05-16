package com.example.online_banking_system.services;

import com.example.online_banking_system.entities.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    public List<Transaction> getAllTransaction(Long accountNumber)  {
        return null;
    }

    public List<Transaction> getLatestAllTransaction(Long accountNumber) {
        return null;
    }
}
