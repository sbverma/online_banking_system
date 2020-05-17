package com.example.online_banking_system.requests;

import com.example.online_banking_system.pojo.Money;

public class WithdrawalMoneyRequest {

    private Long accountId;
    private Money withdrawalAmount;

    public WithdrawalMoneyRequest() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Money getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(Money withdrawalAmount) {
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
