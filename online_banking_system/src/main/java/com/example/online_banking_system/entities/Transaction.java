package com.example.online_banking_system.entities;


import com.example.online_banking_system.enums.Gender;
import com.example.online_banking_system.enums.TransactionStatus;
import com.example.online_banking_system.enums.TransactionType;
import com.example.online_banking_system.pojo.Money;

import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {

    private Long transactionId;
    private Money amount;
    private TransactionType type;
    private TransactionStatus transactionStatus;
    private Account account;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Transaction() {
    }

    public Transaction(Money amount, TransactionType type, TransactionStatus transactionStatus, Account account) {
        this.amount = amount;
        this.type = type;
        this.transactionStatus = transactionStatus;
        this.account = account;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }



    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", type=" + type +
                ", transactionStatus=" + transactionStatus +
                ", account=" + account +
                ", createdAt=" + createdAt +
                '}';
    }
}


