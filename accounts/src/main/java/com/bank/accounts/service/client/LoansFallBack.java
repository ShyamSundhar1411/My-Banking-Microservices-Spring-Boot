package com.bank.accounts.service.client;

import com.bank.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallBack implements LoansFeignClient{

    /**
     * @param mobileNumber - mobile Number
     * @return - Response Entity
     */
    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String mobileNumber) {
        return null;
    }
}
