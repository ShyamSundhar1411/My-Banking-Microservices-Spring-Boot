package com.bank.accounts.service.impl;

import com.bank.accounts.constants.AccountsConstants;
import com.bank.accounts.dto.CustomerDto;
import com.bank.accounts.entity.AccountsEntity;
import com.bank.accounts.entity.CustomerEntity;
import com.bank.accounts.mapper.CustomerMapper;
import com.bank.accounts.repository.AccountsRepository;
import com.bank.accounts.repository.CustomerRepository;
import com.bank.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    /**
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        CustomerEntity customer = CustomerMapper.mapToCustomer(customerDto, new CustomerEntity());
        CustomerEntity savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }
    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private AccountsEntity createNewAccount(CustomerEntity customer) {
        AccountsEntity newAccount = new AccountsEntity();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccount_type(AccountsConstants.SAVINGS);
        newAccount.setBranch_address(AccountsConstants.ADDRESS);
        return newAccount;
    }

}
