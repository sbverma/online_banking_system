package com.example.online_banking_system.requests;

import com.example.online_banking_system.enums.AccountType;
import com.example.online_banking_system.enums.Gender;
import com.example.online_banking_system.pojo.Money;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

public class CreateAccountRequest {

    @NonNull
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    @NonNull
    private String panCardNumber;
    @NonNull
    private String gender;
    @NonNull
    private String accountType;
    @NonNull
    private Double depositAmount;
    @NonNull
    private Long branchId;
    @NonNull
    private String currency;

    public CreateAccountRequest() {
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NonNull LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @NonNull
    public String getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(@NonNull String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    @NonNull
    public String getGender() {
        return gender;
    }

    public void setGender(@NonNull String gender) {
        this.gender = gender;
    }

    @NonNull
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(@NonNull String accountType) {
        this.accountType = accountType;
    }

    @NonNull
    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(@NonNull Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    @NonNull
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(@NonNull String currency) {
        this.currency = currency;
    }

    @NonNull
    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(@NonNull Long branchId) {
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "CreateAccountRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", panCardNumber='" + panCardNumber + '\'' +
                ", gender=" + gender +
                ", accountType=" + accountType +
                ", depositAmount=" + depositAmount +
                ", branchId='" + branchId + '\'' +
                '}';
    }
}
