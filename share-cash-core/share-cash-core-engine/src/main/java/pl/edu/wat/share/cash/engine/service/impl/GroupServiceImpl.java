package pl.edu.wat.share.cash.engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.share.cash.common.dto.GroupDto;

import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.dto.PersonGroupDto;
import pl.edu.wat.share.cash.engine.provider.GroupProvider;

import pl.edu.wat.share.cash.engine.provider.PersonGroupProvider;
import pl.edu.wat.share.cash.engine.service.GroupService;


import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {


    @Autowired
    GroupProvider groupProvider;

    @Autowired
    PersonGroupProvider personGroupProvider;


    @Override
    public GroupDto createGroup(GroupDto group) {
        return groupProvider.createGroup(group);
    }

    @Override
    public GroupDto updateGroup(Long groupId, GroupDto group) {
        return groupProvider.updateGroup(groupId, group);
    }

    @Override
    public GroupDto getGroup(Long groupId) {
        return groupProvider.getGroup(groupId);
    }

    @Override
    public void deleteGroup(Long groupId) {
        groupProvider.deleteGroup(groupId);
    }

    @Override
    public List<GroupDto> getAllGroups() { return groupProvider.getAllGroups(); }

    @Override
    public GroupDto addMember(Long groupId, PersonDto person, Integer percent) {
        if(person == null) {
            return null;
        }

        Long personId = person.getId();
        if(personGroupProvider.existsPersonGroup(groupId, personId)) {
            return groupProvider.getGroup(groupId);
        }

        GroupDto group = groupProvider.getGroup(groupId);

        PersonGroupDto personGroup = new PersonGroupDto();
        personGroup.setGroupId(groupId);
        personGroup.setPersonId(personId);
        personGroup.setPercent(percent);
        PersonGroupDto personGroupSaved = personGroupProvider.createPersonGroup(personGroup);

        if(group != null && group.getMembers() != null) {
            group.getMembers().add(personGroupSaved);
        }

        return groupProvider.updateGroup(groupId, group);
    }

}
