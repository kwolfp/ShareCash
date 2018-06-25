package pl.edu.wat.share.cash.engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.share.cash.common.dto.TransactionDto;
import pl.edu.wat.share.cash.engine.provider.TransactionProvider;
import pl.edu.wat.share.cash.engine.service.TransactionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl extends BaseService implements TransactionService {

    @Autowired
    TransactionProvider transactionProvider;


    @Override
    public TransactionDto createTransaction(TransactionDto transaction) {
        if(transaction != null && isGroupMember(transaction.getPayerId())) {
            return transactionProvider.createTransaction(transaction);
        }
        return null;
    }

    @Override
    public TransactionDto updateTransaction(Long transactionId, TransactionDto transaction) {
        if(transaction != null && isGroupMember(transaction.getPayerId())) {
            return transactionProvider.updateTransaction(transactionId, transaction);
        }
        return null;
    }

    @Override
    public TransactionDto getTransaction(Long transactionId) {
        if(isGroupMember(transactionId)) {
            return transactionProvider.getTransaction(transactionId);
        }
        return null;
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        if(isGroupMember(transactionId)) {
            transactionProvider.deleteTransaction(transactionId);
        }
    }

    @Override
    public List<TransactionDto> getTransactionByPersonId(Long personId) {
        List<TransactionDto> transactions = transactionProvider.getTransactionByPersonId(personId);
        return transactions.stream()
                .filter(e -> isTransactionOwner(e))
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto getLastTransactionByPersonId(Long personId) {
        TransactionDto transaction = transactionProvider.getLastTransactionByPersonId(personId);
        if(isTransactionOwner(transaction)) {
            return transaction;
        }
        return null;
    }

    @Override
    public List<TransactionDto> getTransactionsLocationsByPersonId(Long personId) {
        List<TransactionDto> transactions = transactionProvider.getTransactionsLocationsByPersonId(personId);
        return transactions.stream()
                .filter(e -> isTransactionOwner(e))
                .collect(Collectors.toList());
    }
}
