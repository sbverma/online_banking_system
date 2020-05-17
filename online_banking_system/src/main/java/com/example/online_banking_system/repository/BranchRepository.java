package com.example.online_banking_system.repository;

import com.example.online_banking_system.entities.Branch;
import com.example.online_banking_system.exceptions.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

@Repository
public class BranchRepository {

  private static CopyOnWriteArrayList<Branch> branchList = new CopyOnWriteArrayList<>();
  private static AtomicLong uniqueBranchId = new AtomicLong(0);
  //TODO
  private static ConcurrentHashMap<String, Boolean> lockedAccounts = new ConcurrentHashMap<>();

  public Optional<Branch> findBranchById(Long branchId) {
    for (Branch branch : branchList) {
      if (branch.getBranchId().equals(branchId)) {
        return Optional.of(branch);
      }
    }
    return Optional.empty();
  }

  public Branch saveBranch(Branch newBranch) throws ConstraintViolationException {
    for (Branch branch : branchList) {
      if (branch.equals(newBranch)) {
        throw new ConstraintViolationException("Branch : " + newBranch + " already exists");
      }
    }
    newBranch.setBranchId(uniqueBranchId.addAndGet(1));
    branchList.add(newBranch);
    return newBranch;
  }

  public List<Branch> getAllBrnches(Long headOfficeId) {
    List<Branch> allBranchesOfHeadOffice = new ArrayList<>();
    for(Branch branch : branchList) {
      if(headOfficeId.equals(branch.getHeadBranchId())) {
        allBranchesOfHeadOffice.add(branch);
      }
    }
    return allBranchesOfHeadOffice;
  }
}
