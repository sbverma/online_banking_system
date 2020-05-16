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
    @NonNull
    private LocalDateTime dateOfBirth;
    @NonNull
    private String panCardNumber;
    @NonNull
    private Gender gender;
    @NonNull
    private AccountType accountType;
    @NonNull
    private Money depositAmount;
    @NonNull
    private String branchId;

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
    public Gender getGender() {
        return gender;
    }

    public void setGender(@NonNull Gender gender) {
        this.gender = gender;
    }

    @NonNull
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(@NonNull AccountType accountType) {
        this.accountType = accountType;
    }

    @NonNull
    public Money getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(@NonNull Money depositAmount) {
        this.depositAmount = depositAmount;
    }

    @NonNull
    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(@NonNull String branchId) {
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
