package pl.edu.wat.share.cash.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.wat.share.cash.domain.entity.Transaction;

@RepositoryRestResource(collectionResourceRel = "transaction", path = "transaction")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
