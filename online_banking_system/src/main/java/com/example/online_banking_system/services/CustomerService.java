package com.example.online_banking_system.services;

import com.example.online_banking_system.entities.Customer;
import com.example.online_banking_system.enums.Gender;
import com.example.online_banking_system.exceptions.ConstraintViolationException;
import com.example.online_banking_system.exceptions.CustomerRequiredButNotFoundException;
import com.example.online_banking_system.repository.CustomerRepository;
import com.example.online_banking_system.requests.CreateAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> getCustomerByPan(String panNumer) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByPanNo(panNumer);
        Customer customer;
        if(optionalCustomer.isEmpty()) {
            return Optional.empty();
//            throw new CustomerRequiredButNotFoundException();
        }
        return optionalCustomer;
    }

    public Customer createCustomer(CreateAccountRequest createAccountRequest) throws ConstraintViolationException {
        Gender gender = Gender.getGenderFromString(createAccountRequest.getGender());
        Customer customer = new Customer(createAccountRequest.getPanCardNumber(), createAccountRequest.getFirstName(), createAccountRequest.getLastName(), gender);
        customerRepository.saveCustomer(customer);
        return customer;

    }
}
