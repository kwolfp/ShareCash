package pl.edu.wat.share.cash.engine.service;

import pl.edu.wat.share.cash.common.dto.GroupDto;
import pl.edu.wat.share.cash.common.dto.JoinGroupDto;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.enums.GroupJoinStatusEnum;

import java.util.List;

public interface GroupService {
    GroupDto createGroup(GroupDto group);
    GroupDto updateGroup(Long groupId, GroupDto group);
    GroupDto getGroup(Long groupId);
    void deleteGroup(Long groupId);
    List<GroupDto> getAllGroups();
    GroupDto addMember(Long groupId, PersonDto person, Integer percent);
    GroupJoinStatusEnum joinGroup(Long groupId, JoinGroupDto joinGroup);
    List<GroupDto> getGroupsByMemberId(Long personId);
}
