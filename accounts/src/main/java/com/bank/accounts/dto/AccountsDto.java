package com.bank.accounts.dto;


import lombok.Data;

@Data
public class AccountsDto {

    private Long accountNumber;


    private String account_type;

    private String branch_address;
}
