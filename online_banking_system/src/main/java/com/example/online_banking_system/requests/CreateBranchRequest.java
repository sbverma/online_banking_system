package com.example.online_banking_system.requests;

import com.example.online_banking_system.pojo.BranchAddress;

public class CreateBranchRequest {

    private String branchName;
    private BranchAddress address;
    private Long headBranchId;

    public CreateBranchRequest() {
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
        return "CreateBranchRequest{" +
                "branchName='" + branchName + '\'' +
                ", address=" + address +
                ", headBranchId=" + headBranchId +
                '}';
    }
}
