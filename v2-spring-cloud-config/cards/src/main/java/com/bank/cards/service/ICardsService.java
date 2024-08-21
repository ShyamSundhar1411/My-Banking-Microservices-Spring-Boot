package com.bank.cards.service;

import com.bank.cards.dto.CardsDto;

public interface ICardsService {
    /**
     *
     * @param mobileNumber - mobileNumber
     */
    void createCard(String mobileNumber);

    CardsDto fetchCard(String mobileNumber);

    boolean updateCard(CardsDto cardsDto);
    boolean deleteCard(String mobileNumber);
}
