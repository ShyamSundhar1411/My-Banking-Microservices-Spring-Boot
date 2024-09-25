package com.bank.accounts.service.client;

import com.bank.accounts.dto.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallBack implements CardsFeignClient{
    /**
     * @param mobileNumber - mobileNumber
     * @return - Response Entity
     */
    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String mobileNumber) {
        return null;
    }
}
