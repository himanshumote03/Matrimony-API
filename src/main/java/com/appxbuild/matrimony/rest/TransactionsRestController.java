package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Transactions;
import com.appxbuild.matrimony.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionsRestController {

    private TransactionsService transactionsService;

    @Autowired
    public TransactionsRestController(TransactionsService theTransactionsService){
        transactionsService = theTransactionsService;
    }

    // expose "/transactions" and return a list of transactions
    @GetMapping("/transactions")
    public List<Transactions> findAll(){
        return transactionsService.findAll();
    }

    // add mapping for GET "/transactions/{transactionsId}" to get a transaction
    @GetMapping("/transactions/{transactionsId}")
    public Transactions findById(@PathVariable int transactionsId){
        Transactions theTransactions = transactionsService.findById(transactionsId);
        if(theTransactions == null){
            throw new RuntimeException("Transaction Id is not found " + transactionsId);
        }
        return theTransactions;
    }

    // add mapping for GET "/transactions" to add new transaction
    @PostMapping("/transactions")
    public Transactions addTransaction(@RequestBody Transactions theTransactions){
        theTransactions.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theTransactions.setCreated(localDateTime);
        theTransactions.setModified(null);
        Transactions newTransaction = transactionsService.save(theTransactions);
        return newTransaction;
    }

    // add mapping for GET "/transactions" to update transaction
    @PutMapping("/transactions")
    public Transactions updateTransaction(@RequestBody Transactions theTransactions){
        LocalDateTime localDateTime = LocalDateTime.now();
        theTransactions.setModified(localDateTime);
        Transactions newTransaction = transactionsService.save(theTransactions);
        return newTransaction;
    }

    // add mapping for GET "/transactions/{transactionsId}" to get a transaction
    @DeleteMapping("/transactions/{transactionsId}")
    public String deleteById(@PathVariable int transactionsId){
        Transactions theTransactions = transactionsService.findById(transactionsId);
        transactionsService.deleteById(transactionsId);
        if(theTransactions == null){
            throw new RuntimeException("Transaction Id is not found " + transactionsId);
        }
        return "deleted Transaction id " + transactionsId;
    }
}
