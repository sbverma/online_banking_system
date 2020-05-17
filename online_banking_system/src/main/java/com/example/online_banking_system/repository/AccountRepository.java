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

  private static List<Account> accountList = new ArrayList<>();
  private static AtomicLong uniqueAccountId = new AtomicLong(0);
  private static Map<String, Boolean> lockedItems = new ConcurrentHashMap<String, Boolean>();

  public Optional<Account> findAccountById(Long accountId) {
    while(true) {
      if(!lockedItems.containsKey(accountId.toString())) {
        break;
      }
    }
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
    newAccount.setAccountId(uniqueAccountId.getAndAdd(1));
    accountList.add(newAccount);
  }

  public Account updateAccount(Account account, Money updatedbalance) {
    while(true) {
      if(!lockedItems.containsKey(account.getAccountId().toString())) {
        break;
      }
    }
    lockedItems.put(account.getAccountId().toString(), true);
    Double currentBalance = account.getCurrentBalance().getAmount();
    Double depositAmount = updatedbalance.getAmount();
    account.getCurrentBalance().setAmount(currentBalance + depositAmount);
    lockedItems.remove(account.getAccountId().toString());
    return account;
  }
}
