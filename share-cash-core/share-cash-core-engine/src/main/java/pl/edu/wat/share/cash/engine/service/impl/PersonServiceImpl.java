package pl.edu.wat.share.cash.engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.share.cash.common.dto.GroupDto;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.engine.provider.GroupProvider;
import pl.edu.wat.share.cash.engine.provider.PersonProvider;
import pl.edu.wat.share.cash.engine.service.PersonService;

import java.util.List;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonProvider provider;

    @Override
    public PersonDto createPerson(PersonDto person) {
        return provider.createPerson(person);
    }

    @Override
    public PersonDto updatePerson(Long personId, PersonDto person) {
        return provider.updatePerson(personId, person);
    }

    @Override
    public PersonDto getPerson(Long personId) {
        return provider.getPerson(personId);
    }

    @Override
    public void deletePerson(Long personId) {
        provider.deletePerson(personId);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return provider.getAllPersons();
    }



}
