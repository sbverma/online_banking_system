package com.example.online_banking_system.exceptions;

import com.example.online_banking_system.responses.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@ControllerAdvice
@RestController
public class CustomisedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public final ErrorResponse handleCustomerNotFound(AccountNotFoundException e) {
        return new ErrorResponse("No account exist with this account number", e);
    }

    @ExceptionHandler(AccountTypeIsNotValidException.class)
    public final ErrorResponse handleNoBankAccountExist(AccountTypeIsNotValidException e) {
        return new ErrorResponse("Account Type is not Valid", e);
    }

    @ExceptionHandler(AfterWithdrwalAmountCannotBelLessThenMinimumAmountException.class)
    public final ErrorResponse handleNoBankAccountExist(AfterWithdrwalAmountCannotBelLessThenMinimumAmountException e) {
        return new ErrorResponse("After Withdrwal Amount Cannot Be Less Then Minimum Amount Exception", e);
    }

    @ExceptionHandler(BranchNotFoundException.class)
    public final ErrorResponse handleTransactionFailed(BranchNotFoundException e) {
        return new ErrorResponse("Branch not found", e);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ErrorResponse handleNotSufficientBalanceException(ConstraintViolationException e) {
        return new ErrorResponse(e.getMessage(), e);
    }

    @ExceptionHandler(CurrentBalanceShouldBeAtleastEqualToMinBalance.class)
    public final ErrorResponse handleNotSufficientBalanceException(CurrentBalanceShouldBeAtleastEqualToMinBalance e) {
        return new ErrorResponse("current balance should be greater then minimum balance", e);
    }

    @ExceptionHandler(CustomerRequiredButNotFoundException.class)
    public final ErrorResponse handleNotSufficientBalanceException(CustomerRequiredButNotFoundException e) {
        return new ErrorResponse("Customer not found", e);
    }

}
