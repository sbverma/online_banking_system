package com.example.online_banking_system.controller;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.entities.Branch;
import com.example.online_banking_system.entities.Customer;
import com.example.online_banking_system.exceptions.BranchNotFoundException;
import com.example.online_banking_system.exceptions.ConstraintViolationException;
import com.example.online_banking_system.requests.CreateBranchRequest;
import com.example.online_banking_system.responses.CreateBranchResponse;
import com.example.online_banking_system.services.HeadOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banking-system")
public class BranchController {
    @Autowired
    public HeadOfficeService headOfficeService;

    @GetMapping("/get-all-branches/{headOfficeId}")
    public List<Branch> getAllBranches(@PathVariable("headOfficeId") Long headOfficeId) {
        return headOfficeService.getAllBranches(headOfficeId);
    }

    @GetMapping("/get-branch/{branchId}")
    public Branch getBranch(@PathVariable("branchId") Long branchId) throws BranchNotFoundException {
        return headOfficeService.getBranchById(branchId);
    }

    @PostMapping("/create-branch")
    public Branch createBranch(@RequestBody CreateBranchRequest createBranchRequest) throws BranchNotFoundException, ConstraintViolationException {
        Branch branch = headOfficeService.createBranch(createBranchRequest);
        return branch;
    }

}
