package pl.edu.wat.share.cash.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.share.cash.common.dto.CreditCardDto;
import pl.edu.wat.share.cash.common.rest.CreditCardRest;
import pl.edu.wat.share.cash.engine.service.CreditCardService;

@RestController
public class CreditCardRestController implements CreditCardRest {

    @Autowired
    CreditCardService creditCardService;

    @Override
    public CreditCardDto createCreditCard(@RequestBody CreditCardDto card) {
        return creditCardService.createCreditCard(card);
    }

    @Override
    public CreditCardDto updateCreditCard(@PathVariable("creditCardId") Long creditCardId, @RequestBody CreditCardDto card) {
        return creditCardService.updateCreditCard(creditCardId, card);}

    @Override
    public CreditCardDto getCreditCard(@PathVariable("creditCardId") Long creditCardId) {
        return creditCardService.getCreditCard(creditCardId);
    }

    @Override
    public void deleteCreditCard(@PathVariable("creditCardId") Long creditCardId) {
        creditCardService.deleteCreditCard(creditCardId);


    }
}
