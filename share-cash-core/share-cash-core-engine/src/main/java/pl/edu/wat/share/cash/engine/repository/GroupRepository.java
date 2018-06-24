package pl.edu.wat.share.cash.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.wat.share.cash.domain.entity.Group;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "group", path = "group")
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query(value = "select * from t_group gr " +
                   "where gr.id in ( " +
                   "  select distinct pg.group_id from t_person_group pg where pg.person_id = ?1 " +
                   ") " +
                   "order by gr.creation_date desc",nativeQuery = true)
    List<Group> getGroupsByMemberId(Long personId);
}
