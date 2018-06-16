package pl.edu.wat.share.cash.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.rest.PersonRest;
import pl.edu.wat.share.cash.engine.service.PersonService;

import java.util.List;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@RestController
public class PersonRestController implements PersonRest {

    @Autowired
    PersonService service;


    @Override
    public PersonDto createPerson(@RequestBody PersonDto person) {
        return service.createPerson(person);
    }

    @Override
    public PersonDto updatePerson(@PathVariable("personId") Long personId, @RequestBody PersonDto person) {
        return service.updatePerson(personId, person);
    }

    @Override
    public PersonDto getPerson(@PathVariable("personId") Long personId) {
        return service.getPerson(personId);
    }

    @Override
    public void deletePerson(@PathVariable("personId") Long personId) {
        service.deletePerson(personId);
    }

    @Override
    public List<PersonDto> getAllPersons() { return service.getAllPersons(); }

    @Override
    public PersonDto getPersonByUserName(@PathVariable("username") String username) {
        return service.getPersonByUserName(username);
    }

}
