package com.example.online_banking_system.pojo;

public class BranchAddress {
    private String state;
    private String pinCode;
    private String landmark;
    private String address;

    public BranchAddress() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BranchAddress{" +
                "state='" + state + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", landmark='" + landmark + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
