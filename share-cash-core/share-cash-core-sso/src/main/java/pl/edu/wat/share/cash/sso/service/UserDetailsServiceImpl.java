package pl.edu.wat.share.cash.sso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.wat.share.cash.domain.entity.Person;
import pl.edu.wat.share.cash.sso.principal.PersonPrincipal;
import pl.edu.wat.share.cash.sso.repository.PersonRepositorySso;

/**
 * Created by Kamil Przyborowski, Date: 04.06.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    PersonRepositorySso personRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Person person = personRepository.findByUserName(userName);
        if(person == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new PersonPrincipal(person);
    }

}
