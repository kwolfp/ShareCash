package pl.edu.wat.share.cash.common.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.rest.base.BaseRest;

import java.util.List;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@RequestMapping(PersonRest.PATH)
public interface PersonRest extends BaseRest {
    String PATH = BASE_PATH + "persons";


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    PersonDto createPerson(@RequestBody PersonDto person);

    @RequestMapping(value = "/update/{personId}", method = RequestMethod.PUT)
    PersonDto updatePerson(@PathVariable("personId") Long personId, @RequestBody PersonDto person);

    @RequestMapping(value = "/{personId}", method = RequestMethod.GET)
    PersonDto getPerson(@PathVariable("personId") Long personId);

    @RequestMapping(value = "/delete/{personId}", method = RequestMethod.DELETE)
    void deletePerson(@PathVariable("personId") Long personId);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<PersonDto> getAllPersons();

}
