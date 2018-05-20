package pl.edu.wat.share.cash.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.rest.PersonRest;

import java.util.List;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRest personRest;



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getPersonsList(Model model) {
        List<PersonDto> persons = personRest.getAllPersons();
        model.addAttribute("persons", persons);

        return "persons";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPerson(Model model, @RequestBody PersonDto person) {
        personRest.createPerson(person);

        List<PersonDto> persons = personRest.getAllPersons();
        model.addAttribute("persons", persons);
        return "persons";
    }

}
