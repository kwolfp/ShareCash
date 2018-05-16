package pl.edu.wat.share.cash.engine.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.mapper.Mapper;
import pl.edu.wat.share.cash.domain.entity.Person;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Component
public class PersonMapper implements Mapper {
    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(Person.class, PersonDto.class)
                .byDefault().register();
    }
}
