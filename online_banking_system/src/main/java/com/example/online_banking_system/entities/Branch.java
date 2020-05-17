package com.example.online_banking_system.entities;


import com.example.online_banking_system.pojo.BranchAddress;
import java.util.Objects;

public class Branch {

    private Long branchId;
    private String ifscCode;
    private String branchName;
    private BranchAddress address;
    private Long headBranchId;

    public Branch() {
    }

    public Branch(String ifscCode, String branchName, BranchAddress address, Long headBranchId) {
        this.ifscCode = ifscCode;
        this.branchName = branchName;
        this.address = address;
        this.headBranchId = headBranchId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public BranchAddress getAddress() {
        return address;
    }

    public void setAddress(BranchAddress address) {
        this.address = address;
    }

    public Long getHeadBranchId() {
        return headBranchId;
    }

    public void setHeadBranchId(Long headBranchId) {
        this.headBranchId = headBranchId;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", ifscCode='" + ifscCode + '\'' +
                ", branchName='" + branchName + '\'' +
                ", address=" + address +
                ", headBranchId=" + headBranchId +
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
        Branch branch = (Branch) o;
        return Objects.equals(branchId, branch.branchId);
    }

}
