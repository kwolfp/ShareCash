package pl.edu.wat.share.cash.common.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.dto.TransactionDto;

import java.util.List;

import static pl.edu.wat.share.cash.common.rest.base.BaseRest.BASE_PATH;

@RequestMapping(TransactionRest.PATH)
public interface TransactionRest {
    String PATH = BASE_PATH + "transactions";


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    TransactionDto createTransaction(@RequestBody TransactionDto transaction);

    @RequestMapping(value = "/update/{transactionId}", method = RequestMethod.PUT)
    TransactionDto updateTransaction(@PathVariable("transactionId") Long transactionId, @RequestBody TransactionDto transactions);

    @RequestMapping(value = "/{transactionId}", method = RequestMethod.GET)
    TransactionDto getTransaction(@PathVariable("transactionId") Long transactionId);

    @RequestMapping(value = "/delete/{transactionId}", method = RequestMethod.DELETE)
    void deleteTransaction(@PathVariable("transactionId") Long transactionId);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<TransactionDto> getAllTransactions();

    @RequestMapping(value = "/persons/{personId}", method = RequestMethod.GET)
    List<TransactionDto> getTransactionByPersonId(@PathVariable("personId") Long personId);

    @RequestMapping(value = "/persons/{personId}/last", method = RequestMethod.GET)
    TransactionDto getLastTransactionByPersonId(@PathVariable("personId") Long personId);

}
