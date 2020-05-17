package com.example.online_banking_system.entities;


import com.example.online_banking_system.enums.Gender;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Customer {

    private Long customerId;
    private String panNumber;
    private String FirstName;
    private String LastName;
    private Gender gender;

    public Customer() {
    }

    public Customer(Long customerId, String panNumber, String firstName, String lastName, Gender gender) {
        this.customerId = customerId;
        this.panNumber = panNumber;
        FirstName = firstName;
        LastName = lastName;
        this.gender = gender;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", panNumber='" + panNumber + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", gender=" + gender +
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
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }
}
