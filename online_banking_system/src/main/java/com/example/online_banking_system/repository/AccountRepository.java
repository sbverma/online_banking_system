package com.example.online_banking_system.repository;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.exceptions.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.example.online_banking_system.exceptions.RejectTransactionException;
import com.example.online_banking_system.pojo.Money;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

@Repository
public class AccountRepository {

  private static CopyOnWriteArrayList<Account> accountList = new CopyOnWriteArrayList<>();
  private static AtomicLong uniqueAccountId = new AtomicLong(0);
  private static ConcurrentHashMap<String, Boolean> lockedAccounts = new ConcurrentHashMap<>();

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

  public Boolean updateAccount(Account account, Double updatedBalance) throws RejectTransactionException {
    if(!Objects.isNull(lockedAccounts.get(account.getAccountId().toString()))) {
      throw new RejectTransactionException("Another transaction is already in progress");
    }
    lockedAccounts.put(account.getAccountId().toString(), true);
    account.getCurrentBalance().setAmount(updatedBalance);
    lockedAccounts.remove(account.getAccountId().toString());
    return true;
  }
}
