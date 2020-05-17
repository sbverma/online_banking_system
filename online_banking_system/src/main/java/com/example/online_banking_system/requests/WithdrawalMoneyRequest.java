package com.example.online_banking_system.requests;

import com.example.online_banking_system.pojo.Money;

public class WithdrawalMoneyRequest {

    private Long accountId;
    private Double withdrawalAmount;

    public WithdrawalMoneyRequest() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(Double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    @Override
    public String toString() {
        return "WithdrawalMoneyRequest{" +
                "accountId=" + accountId +
                ", withdrawalAmount=" + withdrawalAmount +
                '}';
    }
}
