package pl.edu.wat.share.cash.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.wat.share.cash.domain.entity.PersonGroup;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@RepositoryRestResource(collectionResourceRel = "person_group", path = "person_group")
public interface PersonGroupRepository extends JpaRepository<PersonGroup, Long> {
    Boolean existsByGroupIdAndPersonId(Long groupId, Long personId);
}
