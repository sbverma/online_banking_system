package com.example.online_banking_system.services;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.entities.Branch;
import com.example.online_banking_system.entities.Customer;
import com.example.online_banking_system.exceptions.BranchNotFoundException;
import com.example.online_banking_system.exceptions.ConstraintViolationException;
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

    public List<Branch> getAllBranches(Long headOfficeId) {
        List<Branch> branches = branchRepository.getAllBrnches(headOfficeId);
        return branches;
    }

    public Branch getBranchById(Long branchId) throws BranchNotFoundException {
        Optional<Branch> optionalBranch = branchRepository.findBranchById(branchId);
        if(optionalBranch.isEmpty()) {
            throw new BranchNotFoundException("Branch " + branchId + " not found in Db");
        }
        return optionalBranch.get();
    }

    public Branch createBranch(CreateBranchRequest createBranchRequest) throws ConstraintViolationException {
        Branch branch = new Branch(createBranchRequest.getIfscCode(), createBranchRequest.getBranchName(), createBranchRequest.getAddress(), createBranchRequest.getHeadBranchId());
        branch = branchRepository.saveBranch(branch);
        return branch;
    }
}
