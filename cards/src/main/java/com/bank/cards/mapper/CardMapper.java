package com.bank.cards.mapper;

import com.bank.cards.dto.CardsDto;
import com.bank.cards.entity.CardsEntity;

public class CardMapper {
    public static CardsDto mapToCardsDto(CardsDto cardsDto, CardsEntity cardsEntity){
        cardsDto.setCardNumber(cardsEntity.getCardNumber());
        cardsDto.setMobileNumber(cardsEntity.getMobileNumber());
        cardsDto.setCardType(cardsEntity.getCardType());
        cardsDto.setAmountUsed(cardsEntity.getAmountUsed());
        cardsDto.setAvailableAmount(cardsEntity.getAvailableAmount());
        cardsDto.setTotalLimit(cardsEntity.getTotalLimit());
        return cardsDto;
    }

    public static void mapToCardsEntity(CardsDto cardsDto, CardsEntity cardsEntity){
        cardsEntity.setCardNumber(cardsDto.getCardNumber());
        cardsEntity.setMobileNumber(cardsDto.getMobileNumber());
        cardsEntity.setCardType(cardsDto.getCardType());
        cardsEntity.setAmountUsed(cardsDto.getAmountUsed());
        cardsEntity.setAvailableAmount(cardsDto.getAvailableAmount());
        cardsEntity.setTotalLimit(cardsDto.getTotalLimit());
    }
}
