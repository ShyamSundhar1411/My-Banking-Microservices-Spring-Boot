package com.bank.cards.service.impl;

import com.bank.cards.dto.CardsDto;
import com.bank.cards.entity.CardsEntity;
import com.bank.cards.exception.ResourceNotFoundException;
import com.bank.cards.mapper.CardMapper;
import com.bank.cards.repository.CardsRepository;
import com.bank.cards.service.ICardsService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ICardsServiceImpl implements ICardsService {
    private CardsRepository cardsRepository;

    /**
     * @param mobileNumber - mobileNumber
     */
    @Override
    public void createCard(String mobileNumber) {

    }

    /**
     * @param mobileNumber - mobileNumber
     * @return card Details
     */
    @Override
    public CardsDto fetchCard(String mobileNumber) {
        CardsEntity cardData = cardsRepository.findCardDetailsByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Cards","mobileNumber",mobileNumber)
        );
        return CardMapper.mapToCardsDto(new CardsDto(),cardData);
    }

    /**
     * @param cardsDto - cardDto object
     * @return boolean indicating update Status
     */
    @Override
    public boolean updateCard(CardsDto cardsDto) {]
        boolean isUpdated = false;
        String cardNumber = cardsDto.getCardNumber();
        if(cardNumber != null){
            CardsEntity cardData = cardsRepository.findCardDetailsByCardNumber(cardNumber).orElseThrow(
                    ()-> new ResourceNotFoundException("Cards","cardNumber",cardNumber)
            );
            CardMapper.mapToCardsEntity(cardsDto,cardData);
            cardsRepository.save(cardData);
            isUpdated = true;
        }
        return isUpdated;
    }

    /**
     * @param mobileNumber - mobileNumber
     * @return boolean indicating delete Status
     */
    @Override
    public boolean deleteCard(String mobileNumber) {
        CardsEntity cardData = cardsRepository.findCardDetailsByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Cards","mobileNumber",mobileNumber)
        );
        cardsRepository.deleteById(cardData.getCardId());
        return true;
    }
}
