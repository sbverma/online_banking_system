package com.example.online_banking_system.controller;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.entities.Customer;
import com.example.online_banking_system.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banking-system")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-customer/{panNumber}")
    public Customer getCustomer(@PathVariable("panNumber") String panNumber) {
        customerService.getCustomerByPan(panNumber);
        return null;
    }
}
