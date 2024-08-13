package com.bank.loans.service.impl;

import com.bank.loans.dto.LoansDto;
import com.bank.loans.entity.LoansEntity;
import com.bank.loans.exception.ResourceNotFoundException;
import com.bank.loans.mapper.LoanMapper;
import com.bank.loans.repository.LoansRepository;
import com.bank.loans.service.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService {
    private LoansRepository loansRepository;

    /**
     * @param loansDto - LoanDto Object
     */
    @Override
    public void createLoan(LoansDto loansDto) {
        LoansEntity loanData = LoanMapper.mapToLoansEntity(new LoansEntity(), loansDto);
        loansRepository.save(loanData);
    }
    /**
     * @param mobileNumber - Mobile Number of the Customer
     * @return the new loan details
     */
    private LoansEntity createNewLoan(String mobileNumber) {
        LoansEntity newLoan = new LoansEntity();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(com.eazybytes.loans.constants.LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(com.eazybytes.loans.constants.LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(com.eazybytes.loans.constants.LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
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

    /**
     * @param loansDto - Loan Details
     * @return - boolean
     */
    @Override
    public boolean updateLoan(LoansDto loansDto) {
        boolean isUpdated = false;
        String loanNumber = loansDto.getLoanNumber();
        if(loanNumber != null) {
            LoansEntity loanData = loansRepository.findLoanByLoanNumber(loanNumber).orElseThrow(
                    () -> new ResourceNotFoundException("Loans", "loanNumber", loanNumber)
            );
            LoanMapper.mapToLoansEntity(loanData, loansDto);
            loansRepository.save(loanData);
            isUpdated = true;
        }
        return isUpdated;
    }

    /**
     * @param mobileNumber - Mobile number associated with loan
     * @return - boolean
     */
    @Override
    public boolean deleteLoan(String mobileNumber) {

        LoansEntity loanData = loansRepository.findLoanByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Loans","mobileNumber",mobileNumber)
        );
        loansRepository.deleteById(loanData.getLoanId());
        return true;
    }
}
