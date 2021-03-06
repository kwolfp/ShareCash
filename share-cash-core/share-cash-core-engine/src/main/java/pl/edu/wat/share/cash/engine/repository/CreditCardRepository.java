package pl.edu.wat.share.cash.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.wat.share.cash.common.dto.CreditCardDto;
import pl.edu.wat.share.cash.domain.entity.CreditCard;
import pl.edu.wat.share.cash.domain.entity.Transaction;

import java.util.List;

/**
 * Created by Kamil Przyborowski, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RepositoryRestResource(collectionResourceRel = "credit_card", path = "credit_card")
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    List<CreditCard> getCreditCardsByOwnerId(Long ownerId);
}
