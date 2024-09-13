package com.bank.loans.service;

import com.bank.loans.dto.LoansDto;

public interface ILoanService {

    /**
     *
     * @param mobileNumber - mobileNumber
     */
    void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);

    boolean updateLoan(LoansDto loansDto);
    boolean deleteLoan(String mobileNumber);

}
