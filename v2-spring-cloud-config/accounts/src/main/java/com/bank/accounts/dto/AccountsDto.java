package com.bank.accounts.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {
    @NotEmpty(message = "Account Number can not be a null or empty")
    @Pattern(regexp = "($[0-9]{10})",message = "Mobile Number must be 10 digit")
    private Long accountNumber;

    @NotEmpty(message = "AccountType can not be a null or empty")
    private String account_type;

    @NotEmpty(message = "BranchAddress can not be a null or empty")
    private String branch_address;
}
