package pl.edu.wat.share.cash.engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.share.cash.common.dto.GroupDto;
import pl.edu.wat.share.cash.common.dto.JoinGroupDto;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.dto.PersonGroupDto;
import pl.edu.wat.share.cash.common.enums.GroupJoinStatusEnum;
import pl.edu.wat.share.cash.engine.provider.GroupProvider;
import pl.edu.wat.share.cash.engine.provider.PersonGroupProvider;
import pl.edu.wat.share.cash.engine.provider.PersonProvider;
import pl.edu.wat.share.cash.engine.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {


    @Autowired
    GroupProvider groupProvider;

    @Autowired
    PersonGroupProvider personGroupProvider;

    @Autowired
    PersonProvider personProvider;


    @Override
    public GroupDto createGroup(GroupDto group) {
        group = groupProvider.createGroup(group);
        addMember(group.getId(), personProvider.getPerson(group.getOwnerId()), 100);
        return group;
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

    @Override
    public GroupJoinStatusEnum joinGroup(Long groupId, JoinGroupDto joinGroup) {
        if(joinGroup == null) {
            return GroupJoinStatusEnum.BAD_DATA;
        }

        Long personId = joinGroup.getPersonId();
        PersonDto person = personProvider.getPerson(personId);
        if(person == null) {
            return GroupJoinStatusEnum.BAD_DATA;
        }

        if(personGroupProvider.existsPersonGroup(groupId, personId)) {
            return GroupJoinStatusEnum.ALREADY_MEMBER;
        }

        GroupDto group = groupProvider.getGroup(groupId);
        if(group == null) {
            return GroupJoinStatusEnum.BAD_ID;
        }

        if(joinGroup.getPassword() == null || !group.getPassword().equals(joinGroup.getPassword())) {
            return GroupJoinStatusEnum.BAD_PASSWORD;
        }

        List<PersonGroupDto> members = personGroupProvider.getGroupMembers(groupId);
        int percent = 100;
        if(members != null && members.size() > 0) {
            percent = 100/(members.size()+1);
        }

        for(PersonGroupDto personGroup : members) {
            personGroup.setPercent(percent);
            personGroupProvider.updatePersonGroup(personGroup.getId(), personGroup);
        }

        PersonGroupDto personGroup = new PersonGroupDto();
        personGroup.setGroupId(groupId);
        personGroup.setPersonId(personId);
        personGroup.setPercent(percent);
        PersonGroupDto personGroupSaved = personGroupProvider.createPersonGroup(personGroup);

        if(group.getMembers() != null) {
            group.getMembers().add(personGroupSaved);
        }

        groupProvider.updateGroup(groupId, group);

        return GroupJoinStatusEnum.JOINED;
    }

    @Override
    public List<GroupDto> getGroupsByMemberId(Long personId) {
        return groupProvider.getGroupsByMemberId(personId);
    }

}
