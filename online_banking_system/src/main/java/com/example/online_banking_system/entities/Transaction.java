package com.example.online_banking_system.entities;


import com.example.online_banking_system.enums.TransactionType;
import com.example.online_banking_system.pojo.TransactionStatus;
import java.util.Date;

public class Transaction {

    private Long transactionId;
    private Double amount;
    private TransactionType type;
    private TransactionStatus transactionStatus;
    private Account account;
    private Date createdAt;

    public Transaction() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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


