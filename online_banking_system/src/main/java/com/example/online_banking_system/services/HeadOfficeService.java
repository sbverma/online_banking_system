package com.example.online_banking_system.services;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.entities.Branch;
import com.example.online_banking_system.entities.Customer;
import com.example.online_banking_system.exceptions.BranchNotFoundException;
import com.example.online_banking_system.repository.BranchRepository;
import com.example.online_banking_system.requests.CreateBranchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeadOfficeService {

    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getAllBranches() {
        List<Branch> branches = branchRepository.getAllBrnches();
        return branches;
    }

    public Branch getBranchById(Long branchId) {
        Optional<Branch> optionalBranch = branchRepository.findBranchById(branchId);
        if(optionalBranch.isEmpty()) {
            throw new BranchNotFoundException("Branch " + branchId + " not found in Db");
        }
        return optionalBranch.get();
    }

    public Branch createBranch(CreateBranchRequest createBranchRequest) {
        Long branchid = 1l;
        Branch branch = new Branch(createBranchRequest.getIfscCode(), createBranchRequest.getBranchName(), createBranchRequest.getAddress(), createBranchRequest.getHeadBranchId());
        branchRepository.saveBranch(branch);
        return branch;
    }
}
