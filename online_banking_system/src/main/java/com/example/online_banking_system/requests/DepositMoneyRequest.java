package com.example.online_banking_system.requests;

import com.example.online_banking_system.pojo.Money;

public class DepositMoneyRequest {

    private Long accountId;
    private Double depositAmount;

    public DepositMoneyRequest() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    @Override
    public String toString() {
        return "DepositMoneyRequest{" +
                "accountId=" + accountId +
                ", depositAmount=" + depositAmount +
                '}';
    }
}
