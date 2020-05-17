package com.example.online_banking_system.controller;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.entities.Customer;
import com.example.online_banking_system.requests.CreateBranchRequest;
import com.example.online_banking_system.responses.CreateBranchResponse;
import com.example.online_banking_system.services.HeadOfficeService;
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
    public HeadOfficeService headOfficeService;

    @GetMapping("/get-all-branches")
    public List<Account> getAllBranches() {
        headOfficeService.getAllBranches();
        return null;
    }

    @GetMapping("/get-branch/{branchId}")
    public List<Account> getBranch(@PathVariable("branchId") Long branchId) {
        headOfficeService.getBranchById(branchId);
        return null;
    }

    @PostMapping("/get-branch/{branchId}")
    public CreateBranchResponse createBranch(CreateBranchRequest createBranchRequest) {
        headOfficeService.createBranch(createBranchRequest);
        return null;
    }

}
