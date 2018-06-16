package pl.edu.wat.share.cash.common.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.share.cash.common.dto.CreditCardDto;
import pl.edu.wat.share.cash.common.rest.base.BaseRest;


@RequestMapping(CreditCardRest.PATH)
public interface CreditCardRest extends BaseRest {
    String PATH = BASE_PATH + "creditCards";
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    CreditCardDto createCreditCard(@RequestBody CreditCardDto card);

    @RequestMapping(value = "/update/{creditCardId}", method = RequestMethod.PUT)
    CreditCardDto updateCreditCard(@PathVariable("creditCardId") Long creditCardId, @RequestBody CreditCardDto card);

    @RequestMapping(value = "/{creditCardId}", method = RequestMethod.GET)
    CreditCardDto getCreditCard(@PathVariable("creditCardId") Long creditCardId);

    @RequestMapping(value = "/delete/{creditCardId}", method = RequestMethod.DELETE)
    void deleteCreditCard(@PathVariable("creditCardId") Long creditCardId);
}
