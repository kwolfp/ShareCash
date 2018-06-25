package pl.edu.wat.share.cash.engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.dto.TransactionDto;
import pl.edu.wat.share.cash.common.session.UserSessionContext;
import pl.edu.wat.share.cash.engine.provider.GroupProvider;
import pl.edu.wat.share.cash.engine.provider.PersonProvider;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public abstract class BaseService {

    @Autowired
    UserSessionContext sessionContext;

    @Autowired
    PersonProvider personProvider;

    @Autowired
    GroupProvider groupProvider;


    protected PersonDto getLoggedInPerson() {
        PersonDto person = sessionContext.getPerson();
        if(person == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            person = personProvider.getPersonByUserName(authentication.getName());
            sessionContext.setPerson(person);
        }
        return person;
    }

    protected boolean isGroupMember(Long groupId) {
        PersonDto person = getLoggedInPerson();
        if(person == null) {
            return false;
        }
        return groupProvider.isGroupMember(groupId, person.getId());
    }

    protected boolean isTransactionOwner(TransactionDto transaction) {
        if(transaction == null) {
            return false;
        }
        return isGroupMember(transaction.getPayerId());
    }

}
