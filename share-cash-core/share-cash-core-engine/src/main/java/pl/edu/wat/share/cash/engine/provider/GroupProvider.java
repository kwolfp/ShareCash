package pl.edu.wat.share.cash.engine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.share.cash.common.dto.GroupDto;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.provider.BaseCrudProvider;
import pl.edu.wat.share.cash.domain.entity.CreditCard;
import pl.edu.wat.share.cash.domain.entity.Group;

import pl.edu.wat.share.cash.domain.entity.Person;
import pl.edu.wat.share.cash.domain.entity.Transaction;
import pl.edu.wat.share.cash.engine.repository.GroupRepository;
import pl.edu.wat.share.cash.engine.repository.PersonRepository;
import pl.edu.wat.share.cash.engine.repository.TransactionRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Component
public class GroupProvider extends BaseCrudProvider<Group, GroupDto> {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    PersonRepository repository;
    @Autowired
    TransactionRepository transactionRepository;

    public GroupDto createGroup(GroupDto group) {
        return convert(groupRepository.save(convert(group, null)));
    }

    public GroupDto updateGroup(Long groupId, GroupDto group) {
        return convert(groupRepository.save(convert(group, groupRepository.getOne(groupId))));
    }

    public GroupDto getGroup(Long groupId) {
        return convert(groupRepository.getOne(groupId));
    }

    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }

    public List<GroupDto> getAllGroups() { return convert(groupRepository.findAll());}
    @Override
    protected Group convert(GroupDto dto, Group entity) {
        if (entity == null) {
            entity = new Group();
        }

        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setCreationDate(dto.getCreationDate());

        if(dto.getOwnerId() != null) {
            entity.setOwner(repository.getOne(dto.getOwnerId()));
        }

        if(dto.getTransactions() != null) {
            List<Transaction> transactions = dto.getTransactions().stream()
                    .filter(Objects::nonNull)
                    .map(cc -> transactionRepository.getOne(cc.getId()))
                    .collect(Collectors.toList());
            entity.setTransactions(transactions);
        }
        return entity;
    }
}
