package com.example.online_banking_system.repository;

import com.example.online_banking_system.entities.Branch;
import com.example.online_banking_system.entities.Transaction;
import com.example.online_banking_system.exceptions.ConstraintViolationException;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository {

  private static CopyOnWriteArrayList<Transaction> transactionsList = new CopyOnWriteArrayList<Transaction>();

  public Optional<Transaction> findTxnById(Long transactionId) {
    for (Transaction txn : transactionsList) {
      if (txn.getTransactionId().equals(transactionId)) {
        return Optional.of(txn);
      }
    }
    return Optional.empty();
  }

  public void saveTxn(Transaction newTransaction) throws ConstraintViolationException {
    for (Transaction txn : transactionsList) {
      if (txn.equals(newTransaction)) {
        throw new ConstraintViolationException("Transaction : " + newTransaction + " already exists");
      }
    }
    transactionsList.add(newTransaction);
  }

}
