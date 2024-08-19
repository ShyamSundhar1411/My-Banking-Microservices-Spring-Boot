package com.bank.cards.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cards")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class CardsEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardId;

    private String mobileNumber;
    private String cardNumber;
    private String cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;

}
