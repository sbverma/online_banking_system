package com.example.online_banking_system.entities;


import com.example.online_banking_system.enums.AccountType;
import com.example.online_banking_system.pojo.DailyWithdrawalLimit;
import com.example.online_banking_system.pojo.Money;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Account {

    private Long accountId;
    private Money currentBalance;
    private Customer customer;
    private AccountType accountType;
    private Branch branch;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Account(Account account) {
        this.accountId = account.getAccountId();
        this.currentBalance = new Money(account.getCurrentBalance().getAmount());
        this.customer = account.getCustomer();
        this.accountType = account.getAccountType();
        this.branch = account.getBranch();
        this.createdAt = account.getCreatedAt();
    }

    public Account() {
    }



    public Account(Money currentBalance,
        Customer customer,
        AccountType accountType, Branch branch) {
        this.currentBalance = currentBalance;
        this.customer = customer;
        this.accountType = accountType;
        this.branch = branch;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Money getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Money currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", currentBalance=" + currentBalance +
                ", customer=" + customer +
                ", accountType=" + accountType +
                ", branch=" + branch +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId);
    }
}
