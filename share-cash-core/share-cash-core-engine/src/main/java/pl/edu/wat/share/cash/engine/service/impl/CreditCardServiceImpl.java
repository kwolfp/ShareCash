package pl.edu.wat.share.cash.engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.share.cash.common.dto.CreditCardDto;
import pl.edu.wat.share.cash.engine.provider.CreditCardProvider;

import pl.edu.wat.share.cash.engine.service.CreditCardService;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    CreditCardProvider cardProvider;


    @Override
    public CreditCardDto createCreditCard(CreditCardDto card) {
        return cardProvider.createCreditCard(card);
    }

    @Override
    public CreditCardDto updateCreditCard(Long creditCardId, CreditCardDto card) {return cardProvider.updateCreditCard(creditCardId, card);
    }

    @Override
    public CreditCardDto getCreditCard(Long creditCardId) { return cardProvider.getCreditCard(creditCardId);
    }

    @Override
    public void deleteCreditCard(Long creditCardId) {
        cardProvider.deleteCreditCard(creditCardId);
    }

    @Override
    public List<CreditCardDto>getCreditCardsByOwnerId(Long ownerId) {
        return cardProvider.getCreditCardsByOwnerId(ownerId);
    }

}
