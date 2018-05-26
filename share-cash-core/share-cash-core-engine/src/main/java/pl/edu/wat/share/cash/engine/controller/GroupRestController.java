package pl.edu.wat.share.cash.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.share.cash.common.dto.GroupDto;
import pl.edu.wat.share.cash.common.rest.GroupRest;
import pl.edu.wat.share.cash.engine.service.GroupService;

import java.util.List;

@RestController
public class GroupRestController implements GroupRest {
    @Autowired
    GroupService service;


    @Override
    public GroupDto createGroup(@RequestBody GroupDto group) {
        return service.createGroup(group);
    }

    @Override
    public GroupDto updateGroup(@PathVariable("groupId") Long groupId, @RequestBody GroupDto group) {
        return service.updateGroup(groupId, group);
    }

    @Override
    public GroupDto getGroup(@PathVariable("groupId") Long groupId) {
        return service.getGroup(groupId);
    }

    @Override
    public void deleteGroup(@PathVariable("groupId") Long groupId) {
        service.deleteGroup(groupId);
    }

    @Override
    public List<GroupDto> getAllGroups() { return service.getAllGroups();
    }
}
