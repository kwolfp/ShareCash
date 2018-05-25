package pl.edu.wat.share.cash.engine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wat.share.cash.common.dto.CreditCardDto;
import pl.edu.wat.share.cash.common.provider.BaseCrudProvider;
import pl.edu.wat.share.cash.domain.entity.CreditCard;
import pl.edu.wat.share.cash.engine.repository.CreditCardRepository;

/**
 * Created by Kamil Przyborowski, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public class CreditCardProvider extends BaseCrudProvider<CreditCard, CreditCardDto> {

    @Autowired
    CreditCardRepository creditCardRepository;


    @Override
    protected CreditCard convert(CreditCardDto dto, CreditCard entity) {
        return null;
    }

}
