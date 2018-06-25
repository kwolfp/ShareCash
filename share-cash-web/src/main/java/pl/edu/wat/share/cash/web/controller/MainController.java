package pl.edu.wat.share.cash.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.share.cash.common.dto.CreditCardDto;
import pl.edu.wat.share.cash.common.dto.GroupDto;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.dto.PersonGroupDto;
import pl.edu.wat.share.cash.common.dto.TransactionDto;
import pl.edu.wat.share.cash.common.rest.CreditCardRest;
import pl.edu.wat.share.cash.common.rest.GroupRest;
import pl.edu.wat.share.cash.common.rest.TransactionRest;
import pl.edu.wat.share.cash.web.view.TransactionLocation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Controller
@RequestMapping("/")
public class MainController extends BaseController {

    @Autowired
    TransactionRest transactionRest;

    @Autowired
    CreditCardRest creditCardRest;

    @Autowired
    GroupRest groupRest;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMainPage() {
        return "main";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        PersonDto person = getLoggedInPerson();
        if(person == null) {
            return "index";
        }

        List<GroupDto> groupsMember = person.getGroups();
        if(groupsMember != null) {
            model.addAttribute("groupsCount", groupsMember.size());
        }

        TransactionDto lastTransaction = transactionRest.getLastTransactionByPersonId(person.getId());

        model.addAttribute("lastTransaction", lastTransaction);
        return "index";
    }

    @RequestMapping(value = "transactions", method = RequestMethod.GET)
    public String getTransactionsPage(Model model) {
        PersonDto person = getLoggedInPerson();
        List<TransactionDto> transactions = transactionRest.getTransactionByPersonId(person.getId());

        model.addAttribute("transactions", transactions);
        return "transactions";
    }

    @RequestMapping(value = "creditCards/add", method = RequestMethod.GET)
    public String getCreditCardsPage() {
        return "creditCards";
    }

    @RequestMapping(value = "creditCards/list", method = RequestMethod.GET)
    public String getCreditCardsList(Model models) {
        PersonDto person = getLoggedInPerson();
        List<CreditCardDto> creditCards = creditCardRest.getCreditCardsByOwnerId(person.getId());

        models.addAttribute("creditCards", creditCards);
        return "creditCards_list";

    }

    @RequestMapping(value = "groups", method = RequestMethod.GET)
    public String getGroupsPage(Model model) {
        PersonDto person = getLoggedInPerson();
        List<GroupDto> groups = groupRest.getGroupsByMemberId(person.getId());

        model.addAttribute("groups", groups);
        return "groups";
    }

    @RequestMapping(value = "locations", method = RequestMethod.GET)
    public String getLocationsPage(Model model) {
        PersonDto person = getLoggedInPerson();
        List<TransactionDto> transactions = transactionRest.getTransactionsLocationsByPersonId(person.getId());
        List<TransactionLocation> locations = transactions.stream()
                .map(transactionDto -> new TransactionLocation(transactionDto.getLatitude(), transactionDto.getLongitude(), transactionDto.getTransactionAddress()))
                .collect(Collectors.toList());

        model.addAttribute("locations", locations);
        return "locations";
    }
}
