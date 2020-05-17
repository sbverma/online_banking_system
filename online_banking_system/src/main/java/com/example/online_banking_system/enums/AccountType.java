package com.example.online_banking_system.enums;

import com.example.online_banking_system.pojo.Money;

public enum AccountType {

    CURRENT_ACCOUNT("current", Money.getCurrent(), 0.0, 1000000d),
    SAVINGS_ACCOUNT("savings", Money.getSavings(), 4.5, 25000d);

    private String accountType;
    private Money minimumAmount;
    private double interest;
    private double dailyWithdrawalLimit;

    AccountType(String accountType, Money minimumAmount, double interest, double dailyWithdrawalLimit) {
        this.accountType = accountType;
        this.minimumAmount = minimumAmount;
        this.interest = interest;
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
    }

    public static AccountType getAccountTypeFromString(String accountTypeString) {
        for(AccountType accountType: values()) {
            if(accountType.accountType.equals(accountTypeString)) {
                return accountType;
            }
        }
        return null;
    }

    public String getAccountType() {
        return accountType;
    }

    public Money getMinimumAmount() {
        return minimumAmount;
    }

    public double getInterest() {
        return interest;
    }

    public double getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }
}
