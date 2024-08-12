package com.bank.loans.service.impl;

import com.bank.loans.dto.LoansDto;
import com.bank.loans.entity.LoansEntity;
import com.bank.loans.exception.ResourceNotFoundException;
import com.bank.loans.mapper.LoanMapper;
import com.bank.loans.repository.LoansRepository;
import com.bank.loans.service.ILoanService;

public class LoanServiceImpl implements ILoanService {
    private LoansRepository loansRepository;

    /**
     * @param loansDto - LoanDto Object
     */
    @Override
    public void createLoan(LoansDto loansDto) {

    }

    /**
     * @param mobileNumber - Mobile Number associated with loan
     * @return - LoansDto
     */
    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        LoansEntity loan = loansRepository.findLoanByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loans","mobile number",mobileNumber)
        );
        LoansDto loanDto = LoanMapper.mapToLoansDto(loan, new LoansDto());
        return null;
    }
}
