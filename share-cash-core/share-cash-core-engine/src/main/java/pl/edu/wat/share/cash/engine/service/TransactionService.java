package pl.edu.wat.share.cash.engine.service;

import pl.edu.wat.share.cash.common.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transaction);
    TransactionDto updateTransaction(Long transactionId, TransactionDto transaction);
    TransactionDto getTransaction(Long transactionId);
    void deleteTransaction(Long transactionId);
    List<TransactionDto> getTransactionByPersonId(Long personId);
    TransactionDto getLastTransactionByPersonId(Long personId);
    List<TransactionDto> getTransactionsLocationsByPersonId(Long personId);
}
