package pl.edu.wat.share.cash.engine.service;

import pl.edu.wat.share.cash.common.dto.GroupDto;
import pl.edu.wat.share.cash.common.dto.PersonDto;

import java.util.List;

public interface GroupService {
    GroupDto createGroup(GroupDto group);
    GroupDto updateGroup(Long groupId, GroupDto group);
    GroupDto getGroup(Long groupId);
    void deleteGroup(Long groupId);
    List<GroupDto> getAllGroups();
    GroupDto addMember(Long groupId, PersonDto person, Integer percent);
}
