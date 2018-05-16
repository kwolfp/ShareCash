package pl.edu.wat.share.cash.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.wat.share.cash.domain.entity.Person;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends JpaRepository<Person, Long> {
}
