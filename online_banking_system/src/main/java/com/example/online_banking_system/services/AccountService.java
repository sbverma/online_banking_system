package com.example.online_banking_system.services;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.entities.CurrentAccount;
import com.example.online_banking_system.entities.Customer;
import com.example.online_banking_system.entities.SavingsAccount;
import com.example.online_banking_system.entities.Transaction;
import com.example.online_banking_system.enums.AccountType;
import com.example.online_banking_system.enums.Gender;
import com.example.online_banking_system.enums.TransactionStatus;
import com.example.online_banking_system.enums.TransactionType;
import com.example.online_banking_system.exceptions.AccountNotFoundException;
import com.example.online_banking_system.exceptions.AccountTypeIsNotValidException;
import com.example.online_banking_system.exceptions.ConstraintViolationException;
import com.example.online_banking_system.pojo.Money;
import com.example.online_banking_system.repository.AccountRepository;
import com.example.online_banking_system.repository.CustomerRepository;
import com.example.online_banking_system.requests.CreateAccountRequest;
import com.example.online_banking_system.requests.DepositMoneyRequest;
import com.example.online_banking_system.requests.WithdrawalMoneyRequest;
import com.example.online_banking_system.validators.MinimumAmountValidator;
import com.example.online_banking_system.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MinimumAmountValidator minimumAmountValidator;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerService customerService;

    public Account createAccount(CreateAccountRequest createAccountRequest) {
        Optional<Customer> optionalCustomer = customerService.getCustomerByPan(createAccountRequest.getPanCardNumber());
        Customer customer;
        if(optionalCustomer.isEmpty()) {
            customer = customerService.createCustomer(createAccountRequest);
        } else {
            customer = optionalCustomer.get();
        }
        Account account;
        AccountType accountType = AccountType.getAccountTypeFromString(createAccountRequest.getAccountType());

        Money depositMoney = new Money(createAccountRequest.getDepositAmount());
        if(AccountType.CURRENT_ACCOUNT.equals(accountType)) {
            account  = new CurrentAccount(customer, depositMoney);
        } else if(AccountType.SAVINGS_ACCOUNT.equals(accountType)) {
            account  = new SavingsAccount(customer, depositMoney);
        } else {
            throw new AccountTypeIsNotValidException("Account Type " + createAccountRequest.getAccountType() + " is not valid" );
        }
        accountRepository.saveAccount(account);
        return account;
    }

    public Account depositMoney(DepositMoneyRequest depositMoneyRequest) {
        Optional<Account> optionalAccount = accountRepository.findAccountById(depositMoneyRequest.getAccountId());
        if(optionalAccount.isEmpty()) {
            throw new AccountNotFoundException("account" + depositMoneyRequest.getAccountId() + " not found");
        }
        Account account = optionalAccount.get();

        // update amount and create txn
        boolean isSuccessfullyUpdated = accountRepository.updateAccount(account, depositMoneyRequest.getDepositAmount());
        if(isSuccessfullyUpdated) {
            transactionService.createTransaction(account, TransactionType.WITHDRAWAL, depositMoneyRequest.getDepositAmount(), TransactionStatus.SUCCESS);
        } else {
            transactionService.createTransaction(account, TransactionType.WITHDRAWAL, depositMoneyRequest.getDepositAmount(), TransactionStatus.FAILED);
        }
        return account;
    }

    public Account withdrawalMoney(WithdrawalMoneyRequest withdrawalMoneyRequest) {
        Optional<Account> optionalAccount = accountRepository.findAccountById(withdrawalMoneyRequest.getAccountId());
        if(optionalAccount.isEmpty()) {
            throw new AccountNotFoundException("account" + withdrawalMoneyRequest.getAccountId() + " not found");
        }
        Account account = optionalAccount.get();
        List<Validator> withdrawalValidators = new ArrayList<Validator>(){{add(minimumAmountValidator); }};
        for(Validator validator : withdrawalValidators) {
            validator.validate(account, withdrawalMoneyRequest.getWithdrawalAmount());
        }

        // update amount and create txn

        boolean isSuccessfullyUpdated = accountRepository.updateAccount(account, withdrawalMoneyRequest.getWithdrawalAmount());
        if(isSuccessfullyUpdated) {
            transactionService.createTransaction(account, TransactionType.WITHDRAWAL, withdrawalMoneyRequest.getWithdrawalAmount(), TransactionStatus.SUCCESS);
        } else {
            transactionService.createTransaction(account, TransactionType.WITHDRAWAL, withdrawalMoneyRequest.getWithdrawalAmount(), TransactionStatus.FAILED);
        }
        return account;
    }

    public Account getAccountByAccountNumber(Long AccountNumber) {
        Optional<Account> optionalAccount = accountRepository.findAccountById(AccountNumber);
        if(optionalAccount.isEmpty()) {
            throw new AccountNotFoundException("account" + AccountNumber + " not found");
        }
        return optionalAccount.get();
    }
}
