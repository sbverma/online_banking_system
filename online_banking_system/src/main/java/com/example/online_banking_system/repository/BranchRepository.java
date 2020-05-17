package com.example.online_banking_system.repository;

import com.example.online_banking_system.entities.Branch;
import com.example.online_banking_system.exceptions.ConstraintViolationException;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class BranchRepository {

  private static CopyOnWriteArrayList<Branch> branchList = new CopyOnWriteArrayList<Branch>();

  public Optional<Branch> findBranchById(Long branchId) {
    for (Branch branch : branchList) {
      if (branch.getBranchId().equals(branchId)) {
        return Optional.of(branch);
      }
    }
    return Optional.empty();
  }

  public void saveBranch(Branch newBranch) throws ConstraintViolationException {
    for (Branch branch : branchList) {
      if (branch.equals(newBranch)) {
        throw new ConstraintViolationException("Branch : " + newBranch + " already exists");
      }
    }
    branchList.add(newBranch);
  }

  public List<Branch> getAllBrnches() {
    return branchList;
  }
}
