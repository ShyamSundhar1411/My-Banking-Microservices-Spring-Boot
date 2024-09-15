package com.bank.accounts.mapper;

import com.bank.accounts.dto.CustomerDetailsDto;
import com.bank.accounts.dto.CustomerDto;
import com.bank.accounts.entity.CustomerEntity;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(CustomerEntity customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }
    public static CustomerDetailsDto mapToCustomerDetailsDto(CustomerEntity customer, CustomerDetailsDto customerDetailsDto) {
        customerDetailsDto.setName(customer.getName());
        customerDetailsDto.setEmail(customer.getEmail());
        customerDetailsDto.setMobileNumber(customer.getMobileNumber());
        return customerDetailsDto;
    }
    public static CustomerEntity mapToCustomer(CustomerDto customerDto, CustomerEntity customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

}