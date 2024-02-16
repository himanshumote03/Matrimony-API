package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.TransactionsStatuses;
import com.appxbuild.matrimony.service.TransactionsStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionsStatusesRestController {

    private TransactionsStatusesService transactionsStatusesService;

    @Autowired()
    public TransactionsStatusesRestController(TransactionsStatusesService theTransactionsStatusesService){
        transactionsStatusesService = theTransactionsStatusesService;
    }


    // expose "/transactionsStatuses" and return a list of transactionsStatuses
    @GetMapping("/transactionsStatuses")
    public List<TransactionsStatuses> findAll(){
        return transactionsStatusesService.findAll();
    }

    // add mapping for GET "/transactionsStatuses/{transactionsStatusesId}"
    @GetMapping("/transactionsStatuses/{transactionsStatusesId}")
    public TransactionsStatuses getTransactionStatus(@PathVariable int transactionsStatusesId){
        TransactionsStatuses theTransactionsStatus = transactionsStatusesService.findById(transactionsStatusesId);
        if(theTransactionsStatus == null){
            throw new RuntimeException("Transaction Status id is not found " + transactionsStatusesId);
        }
        return theTransactionsStatus;
    }

    // add mapping for POST "/transactionsStatuses to add new transactionStatuses
    @PostMapping("/transactionsStatuses")
    public TransactionsStatuses addTransactionStatus(@RequestBody TransactionsStatuses theTransactionsStatuses){
        theTransactionsStatuses.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theTransactionsStatuses.setCreated(localDateTime);
        theTransactionsStatuses.setModified(null);
        TransactionsStatuses newTransactionsStatuses = transactionsStatusesService.save(theTransactionsStatuses);
        return newTransactionsStatuses;
    }

    // add mapping for PUT "/transactionsStatuses to update transactionStatus
    @PutMapping("/transactionsStatuses")
    public TransactionsStatuses updateTransactionStatus(@RequestBody TransactionsStatuses theTransactionsStatuses){
        LocalDateTime localDateTime = LocalDateTime.now();
        theTransactionsStatuses.setModified(localDateTime);
        TransactionsStatuses newTransactionsStatuses = transactionsStatusesService.save(theTransactionsStatuses);
        return newTransactionsStatuses;
    }

    // add mapping for DELETE "/transactionsStatuses to delete transactionStatus
    @DeleteMapping("/transactionsStatuses/{transactionsStatusesId}")
    public String deleteTransactionStatus(@PathVariable int transactionsStatusesId){
        TransactionsStatuses theTransactionsStatuses = transactionsStatusesService.findById(transactionsStatusesId);
        transactionsStatusesService.deleteById(transactionsStatusesId);
        if(theTransactionsStatuses == null){
            throw new RuntimeException("Transaction Status id not found " + transactionsStatusesId);
        }
        return "deleted Transaction Status id " + transactionsStatusesId;
    }

}
