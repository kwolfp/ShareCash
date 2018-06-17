package pl.edu.wat.share.cash.common.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wat.share.cash.common.dto.GroupDto;
import pl.edu.wat.share.cash.common.dto.JoinGroupDto;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.enums.GroupJoinStatusEnum;
import pl.edu.wat.share.cash.common.rest.base.BaseRest;

import java.util.List;
@RequestMapping(GroupRest.PATH)
public interface GroupRest extends BaseRest {
    String PATH = BASE_PATH + "groups";


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GroupDto createGroup(@RequestBody GroupDto group);

    @RequestMapping(value = "/update/{groupId}", method = RequestMethod.PUT)
    GroupDto updateGroup(@PathVariable("groupId") Long groupId, @RequestBody GroupDto group);

    @RequestMapping(value = "/{groupId}", method = RequestMethod.GET)
    GroupDto getGroup(@PathVariable("groupId") Long groupId);

    @RequestMapping(value = "/delete/{groupId}", method = RequestMethod.DELETE)
    void deleteGroup(@PathVariable("groupId") Long groupId);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<GroupDto> getAllGroups();

    @RequestMapping(value = "/{groupId}/members/add", method = RequestMethod.PUT)
    GroupDto addMember(@PathVariable("groupId") Long groupId, @RequestParam("percent") Integer percent, @RequestBody PersonDto person);

    @RequestMapping(value = "/{groupId}/join", method = RequestMethod.PUT)
    GroupJoinStatusEnum joinGroup(@PathVariable("groupId") Long groupId, @RequestBody JoinGroupDto joinGroup);

    @RequestMapping(value = "/members/{personId}", method = RequestMethod.GET)
    List<GroupDto> getGroupsByMemberId(@PathVariable("personId") Long personId);
}
