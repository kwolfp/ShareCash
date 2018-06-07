package pl.edu.wat.share.cash.sso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.share.cash.domain.entity.Person;

/**
 * Created by Kamil Przyborowski, Date: 04.06.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Repository
public interface PersonRepositorySso extends JpaRepository<Person, Long> {
    Person findByUserName(String userName);
}
