package com.bank.loans.repository;

import com.bank.loans.entity.LoansEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository extends JpaRepository<LoansEntity,Long> {
    Optional<LoansEntity> findLoanByMobileNumber(String mobileNumber);
    Optional<LoansEntity> findLoanByLoanNumber(String loanNumber);
}
