package com.example.online_banking_system.repository;

import com.example.online_banking_system.entities.Branch;
import com.example.online_banking_system.entities.Transaction;
import com.example.online_banking_system.exceptions.ConstraintViolationException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository {

  private static CopyOnWriteArrayList<Transaction> transactionsList = new CopyOnWriteArrayList<>();
  private static AtomicLong uniqueTransactionId = new AtomicLong(0);
  //TODO
  private static ConcurrentHashMap<String, Boolean> lockedAccounts = new ConcurrentHashMap<>();

  public Optional<Transaction> findTxnById(Long transactionId) {
    for (Transaction txn : transactionsList) {
      if (txn.getTransactionId().equals(transactionId)) {
        return Optional.of(txn);
      }
    }
    return Optional.empty();
  }

  public Transaction saveTxn(Transaction newTransaction) throws ConstraintViolationException {
    for (Transaction txn : transactionsList) {
      if (txn.equals(newTransaction)) {
        throw new ConstraintViolationException("Transaction : " + newTransaction + " already exists");
      }
    }
    newTransaction.setTransactionId(uniqueTransactionId.addAndGet(1));
    transactionsList.add(newTransaction);
    return newTransaction;
  }

  public List<Transaction> getAllTransactionsOfAccount(Long accountNumber) {
    CopyOnWriteArrayList<Transaction> txnList = new CopyOnWriteArrayList<>();
    for (Transaction txn : transactionsList) {
      if (txn.getAccount().getAccountId().equals(accountNumber)) {
        txnList.add(txn);
      }
    }
    return txnList;
  }

  public List<Transaction> getLastTenTransactionsOfAccount(Long accountNumber) {
    CopyOnWriteArrayList<Transaction> txnList = new CopyOnWriteArrayList<>();
    for (Transaction txn : transactionsList) {
      if (txn.getAccount().getAccountId().equals(accountNumber)) {
        txnList.add(txn);
      }
    }
    //TODO
    int startingIndex = Math.max(txnList.size()-10, 0);
    return txnList.subList(startingIndex, txnList.size());
  }

}
