package pl.edu.wat.share.cash.engine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.dto.TransactionDto;
import pl.edu.wat.share.cash.common.provider.BaseCrudProvider;
import pl.edu.wat.share.cash.domain.entity.Person;
import pl.edu.wat.share.cash.domain.entity.Transaction;
import pl.edu.wat.share.cash.engine.repository.GroupRepository;
import pl.edu.wat.share.cash.engine.repository.TransactionRepository;

import java.util.List;

@Component
public class TransactionProvider extends BaseCrudProvider<Transaction, TransactionDto> {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    GroupRepository groupRepository;


    public TransactionDto createTransaction(TransactionDto transaction) {
        return convert(transactionRepository.save(convert(transaction, null)));
    }

    public TransactionDto updateTransaction(Long transactionId, TransactionDto transaction) {
        return convert(transactionRepository.save(convert(transaction, transactionRepository.getOne(transactionId))));
    }

    public TransactionDto getTransaction(Long transactionId) {
        return convert(transactionRepository.getOne(transactionId));
    }

    public void deleteTransaction(Long transactionId) {
        transactionRepository.delete(transactionId);
    }

    public List<TransactionDto> getAllTransactions() {
        return convert(transactionRepository.findAll());
    }

    public List<TransactionDto> getTransactionByPersonId(Long personId) {
        return convert(transactionRepository.getTransactionsByPersonId(personId));
    }

    public TransactionDto getLastTransactionByPersonId(Long personId) {
        List<TransactionDto> transactionDtoList = convert(transactionRepository.getLastTransactionByPersonId(personId));
        return transactionDtoList.size() > 0 ? transactionDtoList.get(0) : null;
    }

    @Override
    protected Transaction convert(TransactionDto dto, Transaction entity) {
        if (entity == null) {
            entity = new Transaction();
        }
        entity.setName(dto.getName());
        entity.setAmount(dto.getAmount());
        entity.setAdress(dto.getAdress());
        entity.setAccNumber(dto.getAccNumber());
        entity.setTransactionDate(dto.getTransactionDate());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setTransactionAddress(dto.getTransactionAddress());
        if(dto.getPayerId() != null) {
            entity.setPayer(groupRepository.getOne(dto.getPayerId()));
        }
        return entity;
    }
}