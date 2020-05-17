package com.example.online_banking_system.services;

import com.example.online_banking_system.entities.Account;
import com.example.online_banking_system.entities.Branch;
import com.example.online_banking_system.entities.CurrentAccount;
import com.example.online_banking_system.entities.Customer;
import com.example.online_banking_system.entities.SavingsAccount;
import com.example.online_banking_system.entities.Transaction;
import com.example.online_banking_system.enums.AccountType;
import com.example.online_banking_system.enums.TransactionStatus;
import com.example.online_banking_system.enums.TransactionType;
import com.example.online_banking_system.exceptions.AccountNotFoundException;
import com.example.online_banking_system.exceptions.AccountTypeIsNotValidException;
import com.example.online_banking_system.exceptions.AfterWithdrwalAmountCannotBelLessThenMinimumAmountException;
import com.example.online_banking_system.exceptions.BranchNotFoundException;
import com.example.online_banking_system.exceptions.ConstraintViolationException;
import com.example.online_banking_system.exceptions.RejectTransactionException;
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

    @Autowired
    private HeadOfficeService headOfficeService;

    public Account createAccount(CreateAccountRequest createAccountRequest) throws ConstraintViolationException, BranchNotFoundException, AccountTypeIsNotValidException {
        Optional<Customer> optionalCustomer = customerService.getCustomerByPan(createAccountRequest.getPanCardNumber());
        Customer customer;
        if(!optionalCustomer.isPresent()) {
            customer = customerService.createCustomer(createAccountRequest);
        } else {
            customer = optionalCustomer.get();
        }
        Account account;
        AccountType accountType = AccountType.getAccountTypeFromString(createAccountRequest.getAccountType());
        Branch branch = headOfficeService.getBranchById(createAccountRequest.getBranchId());
        Money depositMoney = new Money(createAccountRequest.getDepositAmount());
        if(AccountType.CURRENT_ACCOUNT.equals(accountType)) {
            account  = new CurrentAccount(customer, depositMoney, branch);
        } else if(AccountType.SAVINGS_ACCOUNT.equals(accountType)) {
            account  = new SavingsAccount(customer, depositMoney, branch);
        } else {
            throw new AccountTypeIsNotValidException("Account Type " + createAccountRequest.getAccountType() + " is not valid" );
        }
        account = accountRepository.saveAccount(account);
        return account;
    }

    public Account depositMoney(DepositMoneyRequest depositMoneyRequest) throws AccountNotFoundException, ConstraintViolationException, RejectTransactionException {
        Optional<Account> optionalAccount = accountRepository.findAccountById(depositMoneyRequest.getAccountId());
        if(!optionalAccount.isPresent()) {
            throw new AccountNotFoundException("account" + depositMoneyRequest.getAccountId() + " not found");
        }
        Account account = optionalAccount.get();
        Account acc;
        if(AccountType.CURRENT_ACCOUNT.equals(account.getAccountType())) {
            acc  = new CurrentAccount(account);
        } else {
            acc  = new SavingsAccount(account);
        }
        // update amount and create txn
        Money depositMoney = new Money(depositMoneyRequest.getDepositAmount());
        Double currentBalance = account.getCurrentBalance().getAmount();
        boolean isSuccessfullyUpdated = accountRepository.updateAccount(account, currentBalance + depositMoney.getAmount());
        if(isSuccessfullyUpdated) {
            acc.getCurrentBalance().setAmount(currentBalance + depositMoney.getAmount());
            transactionService.createTransaction(acc, TransactionType.DEPOSIT, depositMoney, TransactionStatus.SUCCESS);
        } else {
            transactionService.createTransaction(acc, TransactionType.DEPOSIT, depositMoney, TransactionStatus.FAILED);
        }
        return account;
    }

    public Account withdrawalMoney(WithdrawalMoneyRequest withdrawalMoneyRequest) throws AccountNotFoundException, AfterWithdrwalAmountCannotBelLessThenMinimumAmountException, ConstraintViolationException, RejectTransactionException {
        Optional<Account> optionalAccount = accountRepository.findAccountById(withdrawalMoneyRequest.getAccountId());
        if(!optionalAccount.isPresent()) {
            throw new AccountNotFoundException("account" + withdrawalMoneyRequest.getAccountId() + " not found");
        }
        Account account = optionalAccount.get();
        List<Validator> withdrawalValidators = new ArrayList<Validator>(){{add(minimumAmountValidator); }};

        Money withdrawalAmount = new Money(withdrawalMoneyRequest.getWithdrawalAmount());
        for(Validator validator : withdrawalValidators) {
            validator.validate(account, withdrawalAmount);
        }

        // update amount and create txn

        Double currentBalance = account.getCurrentBalance().getAmount();
        boolean isSuccessfullyUpdated = accountRepository.updateAccount(account,currentBalance - withdrawalAmount.getAmount());
        Account acc;
        if(AccountType.CURRENT_ACCOUNT.equals(account.getAccountType())) {
            acc  = new CurrentAccount(account);
        } else {
            acc  = new SavingsAccount(account);
        }
        if(isSuccessfullyUpdated) {
            acc.getCurrentBalance().setAmount(currentBalance - withdrawalAmount.getAmount());
            transactionService.createTransaction(acc, TransactionType.WITHDRAWAL, withdrawalAmount, TransactionStatus.SUCCESS);
        } else {
            transactionService.createTransaction(acc, TransactionType.WITHDRAWAL, withdrawalAmount, TransactionStatus.FAILED);
        }
        return account;
    }

    public Account getAccountByAccountNumber(Long AccountNumber) throws AccountNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findAccountById(AccountNumber);
        if(!optionalAccount.isPresent()) {
            throw new AccountNotFoundException("account" + AccountNumber + " not found");
        }
        return optionalAccount.get();
    }
}
