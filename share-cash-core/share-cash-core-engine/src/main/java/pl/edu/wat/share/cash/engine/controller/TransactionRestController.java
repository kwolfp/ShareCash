package pl.edu.wat.share.cash.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.share.cash.common.dto.TransactionDto;
import pl.edu.wat.share.cash.common.rest.TransactionRest;
import pl.edu.wat.share.cash.engine.service.TransactionService;

import java.util.List;

@RestController
public class TransactionRestController implements TransactionRest {

    @Autowired
    TransactionService service;


    @Override
    public TransactionDto createTransaction(@RequestBody TransactionDto transaction) {
        return service.createTransaction(transaction);
    }

    @Override
    public TransactionDto updateTransaction(@PathVariable("transactionId") Long transactionId, @RequestBody TransactionDto transaction) {
        return service.updateTransaction(transactionId, transaction);
    }

    @Override
    public TransactionDto getTransaction(@PathVariable("transactionId") Long transactionId) {
        return service.getTransaction(transactionId);
    }

    @Override
    public void deleteTransaction(@PathVariable("transactionId") Long transactionId) {
        service.deleteTransaction(transactionId);
    }

    @Override
    public List<TransactionDto> getAllTransactions() { return service.getAllTransactions(); }

    @Override
    public List<TransactionDto> getTransactionByPersonId(@PathVariable("personId") Long personId) {
        return service.getTransactionByPersonId(personId);
    }

    @Override
    public TransactionDto getLastTransactionByPersonId(@PathVariable("personId") Long personId) {
        return service.getLastTransactionByPersonId(personId);
    }

}
