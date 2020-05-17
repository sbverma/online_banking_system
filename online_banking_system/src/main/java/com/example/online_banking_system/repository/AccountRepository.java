package com.example.online_banking_system.repository;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.exceptions.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.example.online_banking_system.pojo.Money;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

  private static CopyOnWriteArrayList<Account> accountList = new CopyOnWriteArrayList<>();
  private static AtomicLong uniqueAccountId = new AtomicLong(0);

  public Optional<Account> findAccountById(Long accountId) {
    for (Account account : accountList) {
      if (account.getAccountId().equals(accountId)) {
        return Optional.of(account);
      }
    }
    return Optional.empty();
  }

  public Account saveAccount(Account newAccount) throws ConstraintViolationException {
    for (Account account : accountList) {
      if (account.equals(newAccount)) {
        throw new ConstraintViolationException("Account : " + newAccount + " already exists");
      }
    }
    newAccount.setAccountId(uniqueAccountId.addAndGet(1));
    accountList.add(newAccount);
    return newAccount;
  }

  public Boolean updateAccount(Account account, Double updatedBalance) {
    account.getCurrentBalance().setAmount(updatedBalance);
    return true;
  }
}
