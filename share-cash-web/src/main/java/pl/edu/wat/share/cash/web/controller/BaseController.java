package pl.edu.wat.share.cash.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.rest.PersonRest;
import pl.edu.wat.share.cash.common.session.UserSessionContext;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public abstract class BaseController {

    @Autowired
    UserSessionContext sessionContext;

    @Autowired
    PersonRest personRest;


    protected PersonDto getLoggedInPerson() {
        PersonDto person = sessionContext.getPerson();
        if(person == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            person = personRest.getPersonByUserName(authentication.getName());
            sessionContext.setPerson(person);
        }
        return person;
    }

}
