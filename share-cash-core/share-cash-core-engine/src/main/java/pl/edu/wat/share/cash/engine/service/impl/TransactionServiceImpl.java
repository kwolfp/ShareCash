package pl.edu.wat.share.cash.engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.share.cash.common.dto.TransactionDto;
import pl.edu.wat.share.cash.engine.provider.TransactionProvider;
import pl.edu.wat.share.cash.engine.service.TransactionService;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    TransactionProvider transactionProvider;

    @Override
    public TransactionDto createTransaction(TransactionDto transaction) {
        return transactionProvider.createTransaction(transaction);
    }

    @Override
    public TransactionDto updateTransaction(Long transactionId, TransactionDto transaction) {
        return transactionProvider.updateTransaction(transactionId, transaction);
    }

    @Override
    public TransactionDto getTransaction(Long transactionId) {
        return transactionProvider.getTransaction(transactionId);
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        transactionProvider.deleteTransaction(transactionId);
    }

    @Override
    public List<TransactionDto> getAllTransactions() { return transactionProvider.getAllTransactions(); }
}
