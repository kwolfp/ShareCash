package pl.edu.wat.share.cash.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.wat.share.cash.common.dto.CreditCardDto;
import pl.edu.wat.share.cash.common.rest.CreditCardRest;


@Controller
@RequestMapping("/creditCards")
public class CreditCardController extends BaseController{
    @Autowired
    CreditCardRest creditCardRest;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Boolean createCreditCard(@RequestBody CreditCardDto card) {
        System.out.println(card);

        CreditCardDto createdCreditCard = creditCardRest.createCreditCard(card);
        if(createdCreditCard != null) {
            return true;
        } else {
            return false;
        }
    }
}
