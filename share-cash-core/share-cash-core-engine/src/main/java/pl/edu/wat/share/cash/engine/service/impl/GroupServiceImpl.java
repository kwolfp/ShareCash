package pl.edu.wat.share.cash.engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.share.cash.common.dto.GroupDto;

import pl.edu.wat.share.cash.engine.provider.GroupProvider;

import pl.edu.wat.share.cash.engine.service.GroupService;


import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{


        @Autowired
        GroupProvider groupProvider;


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

}
