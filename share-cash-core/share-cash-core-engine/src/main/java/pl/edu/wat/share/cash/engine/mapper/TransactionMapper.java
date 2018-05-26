package pl.edu.wat.share.cash.engine.mapper;

import ma.glasnost.orika.MapperFactory;
import pl.edu.wat.share.cash.common.dto.TransactionDto;
import pl.edu.wat.share.cash.common.mapper.Mapper;
import pl.edu.wat.share.cash.domain.entity.Transaction;

public class TransactionMapper implements Mapper {
    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(Transaction.class, TransactionDto.class)
                .fieldAToB("payer.id", "payerId")
                .byDefault().register();
    }

}
