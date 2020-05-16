package com.example.online_banking_system.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class DailyWithdrawalLimit {

    private LocalDateTime date;
    private Money amountDebit;

    public DailyWithdrawalLimit() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Money getAmountDebit() {
        return amountDebit;
    }

    public void setAmountDebit(Money amountDebit) {
        this.amountDebit = amountDebit;
    }

    @Override
    public String toString() {
        return "DailyWithdrawalLimit{" +
                "date=" + date +
                ", amountDebit=" + amountDebit +
                '}';
    }
}
