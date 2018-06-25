package pl.edu.wat.share.cash.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.wat.share.cash.domain.entity.Transaction;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "transaction", path = "transaction")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "select * from t_transaction tr " +
                   "where tr.group_id in ( " +
                   "  select distinct pg.group_id from t_person_group pg where pg.person_id = ?1 " +
                   ") order by tr.transaction_date desc",nativeQuery = true)
    List<Transaction> getTransactionsByPersonId(Long personId);

    @Query(value = "select * from t_transaction tr " +
                   "where tr.group_id in ( " +
                   "  select distinct pg.group_id from t_person_group pg where pg.person_id = ?1 " +
                   ") order by tr.transaction_date desc ",nativeQuery = true)
    List<Transaction> getLastTransactionByPersonId(Long personId);

    @Query(value = "select distinct on (tr.transaction_address) tr.* from t_transaction tr " +
                   "where tr.group_id in ( " +
                   "  select distinct pg.group_id from t_person_group pg where pg.person_id = ?1 " +
                   ")",nativeQuery = true)
    List<Transaction> getTransactionsLocationsByPersonId(Long personId);
}
