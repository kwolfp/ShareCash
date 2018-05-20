package pl.edu.wat.share.cash.engine.service;

import pl.edu.wat.share.cash.common.dto.PersonDto;

import java.util.List;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public interface PersonService {
    PersonDto createPerson(PersonDto person);
    PersonDto updatePerson(Long personId, PersonDto person);
    PersonDto getPerson(Long personId);
    void deletePerson(Long personId);
    List<PersonDto> getAllPersons();
}
