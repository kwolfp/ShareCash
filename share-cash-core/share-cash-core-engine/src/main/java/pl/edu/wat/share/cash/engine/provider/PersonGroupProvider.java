package pl.edu.wat.share.cash.engine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.share.cash.common.dto.PersonGroupDto;
import pl.edu.wat.share.cash.common.provider.BaseCrudProvider;
import pl.edu.wat.share.cash.domain.entity.PersonGroup;
import pl.edu.wat.share.cash.engine.repository.GroupRepository;
import pl.edu.wat.share.cash.engine.repository.PersonGroupRepository;
import pl.edu.wat.share.cash.engine.repository.PersonRepository;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Component
public class PersonGroupProvider extends BaseCrudProvider<PersonGroup, PersonGroupDto> {

    @Autowired
    PersonGroupRepository personGroupRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    GroupRepository groupRepository;


    public boolean existsPersonGroup(Long groupId, Long personId) {
        return personGroupRepository.existsByGroupIdAndPersonId(groupId, personId);
    }

    public PersonGroupDto createPersonGroup(PersonGroupDto personGroup) {
        return convert(personGroupRepository.save(convert(personGroup, null)));
    }

    @Override
    protected PersonGroup convert(PersonGroupDto dto, PersonGroup entity) {
        if (entity == null) {
            entity = new PersonGroup();
        }

        if (dto.getPersonId() != null) {
            entity.setPerson(personRepository.getOne(dto.getPersonId()));
        }


        if(dto.getGroupId() != null) {
            entity.setGroup(groupRepository.getOne(dto.getGroupId()));
        }

        entity.setPercent(dto.getPercent());

        return entity;
    }

}
