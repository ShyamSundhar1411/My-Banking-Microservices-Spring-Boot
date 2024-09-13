package com.bank.loans.service.impl;

import com.bank.loans.constants.LoansConstants;
import com.bank.loans.dto.LoansDto;
import com.bank.loans.entity.LoansEntity;
import com.bank.loans.exception.LoanAlreadyExistsException;
import com.bank.loans.exception.ResourceNotFoundException;
import com.bank.loans.mapper.LoanMapper;
import com.bank.loans.repository.LoansRepository;
import com.bank.loans.service.ILoanService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService {
    private static final Logger log = LoggerFactory.getLogger(LoanServiceImpl.class);
    private LoansRepository loansRepository;

    /**
     * @param mobileNumber - Mobile Number of the Customer
     */
    @Override
    public void createLoan(String mobileNumber) {
        Optional<LoansEntity> optionalLoans= loansRepository.findLoanByMobileNumber(mobileNumber);
        if(optionalLoans.isPresent()){
            throw new LoanAlreadyExistsException("Loan already registered with given mobileNumber "+mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
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
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
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
        return LoanMapper.mapToLoansDto(loan, new LoansDto());
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
