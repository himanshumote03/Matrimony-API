package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.TransactionsDAO;
import com.appxbuild.matrimony.entity.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionsServiceImpl implements TransactionsService{

    private TransactionsDAO transactionsDAO;

    @Autowired
    public TransactionsServiceImpl(TransactionsDAO theTransactionsDAO){
        transactionsDAO = theTransactionsDAO;
    }

    @Override
    public List<Transactions> findAll() {
        return transactionsDAO.findAll();
    }

    @Override
    public Transactions findById(int theId) {
        Optional<Transactions> result = transactionsDAO.findById(theId);
        Transactions transactions = null;
        if(result.isPresent()){
            transactions = result.get();
        }
        else {
            throw new RuntimeException("Transaction id is not found " + theId);
        }
        return transactions;
    }

    @Override
    public Transactions save(Transactions theTransactions) {
        return transactionsDAO.save(theTransactions);
    }

    @Override
    public void deleteById(int theId) {
        transactionsDAO.deleteById(theId);

    }
}
