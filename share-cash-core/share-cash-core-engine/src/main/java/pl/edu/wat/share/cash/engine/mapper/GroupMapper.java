package pl.edu.wat.share.cash.engine.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import pl.edu.wat.share.cash.common.dto.GroupDto;
import pl.edu.wat.share.cash.common.mapper.Mapper;
import pl.edu.wat.share.cash.domain.entity.Group;

@Component
public class GroupMapper implements Mapper {
    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(Group.class, GroupDto.class)
                .fieldAToB("owner.id", "ownerId")
                .byDefault().register();
    }

}
