package com.bank.loans.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "loans")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class LoansEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private String loanNumber;
    private String mobileNumber;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
}
