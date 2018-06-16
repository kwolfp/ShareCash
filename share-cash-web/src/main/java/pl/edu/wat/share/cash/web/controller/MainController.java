package pl.edu.wat.share.cash.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.dto.TransactionDto;
import pl.edu.wat.share.cash.common.rest.TransactionRest;

import java.util.List;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Controller
@RequestMapping("/")
public class MainController extends BaseController {

    @Autowired
    TransactionRest transactionRest;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMainPage() {
        return "main";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = "transactions", method = RequestMethod.GET)
    public String getTransactionsPage(Model model) {
        PersonDto person = getLoggedInPerson();
        List<TransactionDto> transactions = transactionRest.getTransactionByPersonId(person.getId());

        model.addAttribute("transactions", transactions);
        return "transactions";
    }
    @RequestMapping(value = "creditCards", method = RequestMethod.GET)
    public String getCreditCardsPage() {
        return "creditCards";
    }
}
