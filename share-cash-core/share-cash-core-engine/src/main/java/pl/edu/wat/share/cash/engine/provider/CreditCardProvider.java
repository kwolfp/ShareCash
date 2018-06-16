package pl.edu.wat.share.cash.engine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.share.cash.common.dto.CreditCardDto;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.provider.BaseCrudProvider;
import pl.edu.wat.share.cash.domain.entity.CreditCard;
import pl.edu.wat.share.cash.domain.entity.Group;
import pl.edu.wat.share.cash.engine.repository.CreditCardRepository;
import pl.edu.wat.share.cash.engine.repository.PersonRepository;

@Component
public class CreditCardProvider extends BaseCrudProvider<CreditCard, CreditCardDto> {

    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    PersonRepository repository;

    public CreditCardDto createCreditCard(CreditCardDto creditCard) { return convert(creditCardRepository.save(convert(creditCard, null))); }

    public CreditCardDto updateCreditCard(Long creditCardId, CreditCardDto creditCard) { return convert(creditCardRepository.save(convert(creditCard, creditCardRepository.getOne(creditCardId))));
    }

    public CreditCardDto getCreditCard(Long creditCardId) {
        return convert(creditCardRepository.getOne(creditCardId));
    }

    public void deleteCreditCard(Long creditCardId) {
        creditCardRepository.delete(creditCardId);
    }

    @Override
    protected CreditCard convert(CreditCardDto dto, CreditCard entity) {
        if (entity == null) {
            entity = new CreditCard();
        }
        entity.setCardNumber(dto.getCardNumber());
        entity.setOwnerName(dto.getOwnerName());
        entity.setOwnerAddress(dto.getOwnerAddress());
        entity.setCountry(dto.getCountry());
        entity.setCsc(dto.getCsc());
        entity.setExp(dto.getExp());
        entity.setProvider(dto.getProvider());

        if(dto.getOwnerId() != null) {
            entity.setOwner(repository.getOne(dto.getOwnerId()));
        }

        return entity;
    }

}
