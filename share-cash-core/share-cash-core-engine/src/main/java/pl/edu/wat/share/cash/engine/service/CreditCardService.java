package pl.edu.wat.share.cash.engine.service;

import pl.edu.wat.share.cash.common.dto.CreditCardDto;


public interface CreditCardService {
    CreditCardDto createCreditCard(CreditCardDto card);
    CreditCardDto updateCreditCard(Long creditCardId, CreditCardDto card);
    CreditCardDto getCreditCard(Long creditCardId);
    void deleteCreditCard(Long creditCardId);
}
