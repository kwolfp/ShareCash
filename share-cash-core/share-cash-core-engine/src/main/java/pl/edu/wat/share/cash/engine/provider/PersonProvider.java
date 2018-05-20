package pl.edu.wat.share.cash.engine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.provider.BaseCrudProvider;
import pl.edu.wat.share.cash.domain.entity.Person;
import pl.edu.wat.share.cash.engine.repository.PersonRepository;

import java.util.List;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Component
public class PersonProvider extends BaseCrudProvider<Person, PersonDto> {

    @Autowired
    PersonRepository repository;


    public PersonDto createPerson(PersonDto person) {
        return convert(repository.save(convert(person, null)));
    }

    public PersonDto updatePerson(Long personId, PersonDto person) {
        return convert(repository.save(convert(person, repository.getOne(personId))));
    }

    public PersonDto getPerson(Long personId) {
        return convert(repository.getOne(personId));
    }

    public void deletePerson(Long personId) {
        repository.deleteById(personId);
    }

    public List<PersonDto> getAllPersons() {
        return convert(repository.findAll());
    }


    @Override
    protected Person convert(PersonDto dto, Person entity) {
        if(entity == null) {
            entity = new Person();
        }

        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());

        return entity;
    }

}
