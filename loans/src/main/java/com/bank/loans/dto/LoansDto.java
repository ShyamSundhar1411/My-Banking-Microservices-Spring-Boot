package com.bank.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class LoansDto {
    @NotEmpty(message = "Mobile Number cannot be null or empty")
    @Pattern(regexp = "$[0-9]{10}",message = "Mobile Number must be 10-digits")
    private String mobileNumber;

    @NotEmpty(message = "Loan Number cannot be empty or null")
    @Pattern(regexp = "$[0-9]{12}",message = "Loan Number must be 12-digits")
    private String loanNumber;

    @NotEmpty(message = "Loan Type cannot be empty or null")
    private String loanType;

    @NotEmpty(message = "Loan Amount cannot be empty or null")
    @Positive(message = "Loan amount should be positive")
    private int totalLoan;

    @PositiveOrZero(message = "Amount paid should be positive or zero")
    private int amountPaid;

    @PositiveOrZero(message = "Outstanding amount should be positive or zero")
    private int outstandingAmount;

}
