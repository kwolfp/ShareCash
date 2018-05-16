package pl.edu.wat.share.cash.engine.provider;

import org.springframework.stereotype.Component;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.provider.BaseCrudProvider;
import pl.edu.wat.share.cash.domain.entity.Person;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Component
public class PersonProvider extends BaseCrudProvider<Person, PersonDto> {

    @Override
    protected Person convert(PersonDto dto, Person entity) {
        return null;
    }

}
