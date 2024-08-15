package com.bank.cards.repository;

import com.bank.cards.entity.CardsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Long, CardsEntity> {
    Optional<CardsEntity> findCardDetailsByMobileNumber(String mobileNumber);
    Optional<CardsEntity> findCardDetailsByCardNumber(String mobileNumber);

}
