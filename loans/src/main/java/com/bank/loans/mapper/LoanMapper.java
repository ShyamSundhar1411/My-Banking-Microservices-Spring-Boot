package com.bank.loans.mapper;

import com.bank.loans.dto.LoansDto;
import com.bank.loans.entity.LoansEntity;

public class LoanMapper {
    public static LoansDto mapToLoansDto(LoansEntity loansEntity, LoansDto loansDto){
        loansDto.setMobileNumber(loansEntity.getMobileNumber());
        loansDto.setLoanNumber(loansEntity.getLoanNumber());
        loansDto.setLoanType(loansEntity.getLoanType());
        loansDto.setTotalLoan(loansEntity.getTotalLoan());
        loansDto.setAmountPaid(loansEntity.getAmountPaid());
        loansDto.setOutstandingAmount(loansEntity.getOutstandingAmount());
        return loansDto;
    }

    public static void mapToLoansEntity(LoansEntity loansEntity, LoansDto loansDto){
        loansEntity.setMobileNumber(loansDto.getMobileNumber());
        loansEntity.setLoanType(loansDto.getLoanType());
        loansEntity.setTotalLoan(loansDto.getTotalLoan());
        loansEntity.setAmountPaid(loansDto.getAmountPaid());
        loansEntity.setOutstandingAmount(loansDto.getOutstandingAmount());
    }
}
