package com.bank.accounts.mapper;

import com.bank.accounts.dto.AccountsDto;
import com.bank.accounts.entity.AccountsEntity;

public class AccountsMapper {
    public static AccountsDto mapToAccountDto(AccountsEntity accounts,AccountsDto accountsDto){
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccount_type(accounts.getAccount_type());
        accountsDto.setBranch_address(accounts.getBranch_address());
        return accountsDto;
    }

    public static AccountsEntity mapToAccountEntity(AccountsEntity accounts, AccountsDto accountsDto){
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccount_type(accountsDto.getAccount_type());
        accounts.setBranch_address(accountsDto.getBranch_address());
        return accounts;
    }
}
