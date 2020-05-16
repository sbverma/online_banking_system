package com.example.online_banking_system.services;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.entities.Branch;
import com.example.online_banking_system.entities.Customer;
import com.example.online_banking_system.requests.CreateBranchRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    public List<Account> getAllAccountsInBranch(Long branchId) {
        return null;
    }

    public List<Branch> getAllBranches() {
        return null;
    }

    public Branch getBranchById(Long branchId) {
        return null;
    }

    public Branch createBranch(CreateBranchRequest createBranchRequest) {
        return null;
    }

    public List<Customer> getAllCustomerInBranch(Long branchId) {
        return null;
    }
}
