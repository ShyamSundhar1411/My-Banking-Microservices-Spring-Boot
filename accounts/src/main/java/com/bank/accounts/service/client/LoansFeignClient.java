package com.bank.accounts.service.client;

import com.bank.accounts.dto.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient
public interface LoansFeignClient {
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam String mobileNumber);
}
