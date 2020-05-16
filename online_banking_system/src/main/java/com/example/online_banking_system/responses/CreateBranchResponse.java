package com.example.online_banking_system.responses;

import com.example.online_banking_system.entities.Branch;

public class CreateBranchResponse {

    private Branch branch;

    public CreateBranchResponse() {
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "CreateBranchResponse{" +
                "branch=" + branch +
                '}';
    }
}
