package com.example.online_banking_system.controller;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.entities.Branch;
import com.example.online_banking_system.entities.Customer;
import com.example.online_banking_system.requests.CreateBranchRequest;
import com.example.online_banking_system.responses.CreateBranchResponse;
import com.example.online_banking_system.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banking-system")
public class BranchController {
    @Autowired
    public BranchService branchService;

    @GetMapping("/get-accounts-from-branch/{branchId}")
    public List<Account> getAllAccountInBranch(@PathVariable("branchId") Long branchId) {
        branchService.getAllAccountsInBranch(branchId);
        return null;
    }

    @GetMapping("/get-all-branches")
    public List<Account> getAllBranches() {
        branchService.getAllBranches();
        return null;
    }

    @GetMapping("/get-branch/{branchId}")
    public List<Account> getBranch(@PathVariable("branchId") Long branchId) {
        branchService.getBranchById(branchId);
        return null;
    }

    @PostMapping("/get-branch/{branchId}")
    public CreateBranchResponse createBranch(CreateBranchRequest createBranchRequest) {
        branchService.createBranch(createBranchRequest);
        return null;
    }

    @GetMapping("/get-all-customer-in-branch/{branchId}")
    public List<Customer> getAllCustomerInBranch(@PathVariable("branchId") Long branchId) {
        branchService.getAllCustomerInBranch(branchId);
        return null;
    }

}
