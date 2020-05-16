package com.example.online_banking_system.responses;

import com.example.online_banking_system.entities.Account;

public class DepositMoneyResponse {
    private Account account;

    public DepositMoneyResponse() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "DepositMoneyResponse{" +
                "account=" + account +
                '}';
    }
}
