package com.example.online_banking_system.repository;

import com.example.online_banking_system.entities.Branch;
import com.example.online_banking_system.entities.Customer;
import com.example.online_banking_system.exceptions.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

  private static CopyOnWriteArrayList<Customer> customerList = new CopyOnWriteArrayList<>();

  public Optional<Customer> findCustomerByPanNo(String panNumber) {
    for (Customer customer : customerList) {
      if (customer.getPanNumber().equalsIgnoreCase(panNumber)) {
        return Optional.of(customer);
      }
    }
    return Optional.empty();
  }

  public void saveCustomer(Customer newCustomer) throws ConstraintViolationException {
    for (Customer customer : customerList) {
      if (customer.equals(newCustomer)) {
        throw new ConstraintViolationException("Customer : " + newCustomer + " already exists");
      }
    }
    customerList.add(newCustomer);
  }
}
