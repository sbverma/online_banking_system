package com.example.online_banking_system.controller;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BranchController {
    @Autowired
    public BranchService branchService;

    @GetMapping("/getAccountsFromBranch/{branchId}")
    public List<Account> getAllAccountInBranch(@PathVariable("branchId") Long branchId) {
        branchService.getAllAccountsInBranch(branchId);
        return null;
    }

    @GetMapping("/getAllBranches")
    public List<Account> getAllBranches() {
        branchService.getAllBranches();
        return null;
    }
}
