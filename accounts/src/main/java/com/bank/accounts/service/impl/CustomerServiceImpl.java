package com.bank.accounts.service.impl;

import com.bank.accounts.dto.AccountsDto;
import com.bank.accounts.dto.CardsDto;
import com.bank.accounts.dto.CustomerDetailsDto;
import com.bank.accounts.dto.LoansDto;
import com.bank.accounts.entity.AccountsEntity;
import com.bank.accounts.entity.CustomerEntity;
import com.bank.accounts.exception.ResourceNotFoundException;
import com.bank.accounts.mapper.AccountsMapper;
import com.bank.accounts.mapper.CustomerMapper;
import com.bank.accounts.repository.AccountsRepository;
import com.bank.accounts.repository.CustomerRepository;
import com.bank.accounts.service.ICustomerService;
import com.bank.accounts.service.client.CardsFeignClient;
import com.bank.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;
    /**
     * @param mobileNumber - Input Mobile Number
     * @return
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        CustomerEntity customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer","mobileNumber",mobileNumber)
        );
        AccountsEntity account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Accounts","customerId",customer.getCustomerId().toString())
        );
        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountDto(account, new AccountsDto()));
        ResponseEntity<CardsDto> cardsResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        if(cardsResponseEntity != null){
            customerDetailsDto.setCardsDto(cardsResponseEntity.getBody());
        }

        ResponseEntity<LoansDto> loansResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        if(loansResponseEntity != null){
            customerDetailsDto.setLoansDto(loansResponseEntity.getBody());
        }

        return customerDetailsDto;
    }
}
