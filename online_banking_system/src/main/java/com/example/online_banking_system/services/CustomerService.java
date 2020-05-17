package com.example.online_banking_system.services;

import com.example.online_banking_system.entities.Customer;
import com.example.online_banking_system.enums.Gender;
import com.example.online_banking_system.exceptions.CustomerRequiredButNotFoundException;
import com.example.online_banking_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerByPan(String panNumer) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByPanNo(panNumer);
        Customer customer;
        if(optionalCustomer.isEmpty()) {
            throw new CustomerRequiredButNotFoundException();
        }
        return optionalCustomer.get();
    }
}
