package pl.edu.wat.share.cash.engine.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import pl.edu.wat.share.cash.common.dto.PersonGroupDto;
import pl.edu.wat.share.cash.common.mapper.Mapper;
import pl.edu.wat.share.cash.domain.entity.PersonGroup;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Component
public class PersonGroupMapper implements Mapper {
    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(PersonGroup.class, PersonGroupDto.class)
                .fieldAToB("person.id", "personId")
                .fieldAToB("group.id", "groupId")
                .byDefault().register();
    }
}
