package com.example.online_banking_system.repository;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.exceptions.ConstraintViolationException;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

  private static CopyOnWriteArrayList<Account> accountList = new CopyOnWriteArrayList<Account>();

  public Optional<Account> findAccountById(Long accountId) {
    for (Account account : accountList) {
      if (account.getAccountId().equals(accountId)) {
        return Optional.of(account);
      }
    }
    return Optional.empty();
  }

  public void saveAccount(Account newAccount) throws ConstraintViolationException {
    for (Account account : accountList) {
      if (account.equals(newAccount)) {
        throw new ConstraintViolationException("Account : " + newAccount + " already exists");
      }
    }
    accountList.add(newAccount);
  }
}
