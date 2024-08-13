package com.bank.loans.service;

import com.bank.loans.dto.LoansDto;

public interface ILoanService {

    /**
     *
     * @param loansDto - LoanDto Object
     */
    void createLoan(LoansDto loansDto);

    LoansDto fetchLoan(String mobileNumber);

    boolean updateLoan(LoansDto loansDto);
    boolean deleteLoan(String mobileNumber);

}
