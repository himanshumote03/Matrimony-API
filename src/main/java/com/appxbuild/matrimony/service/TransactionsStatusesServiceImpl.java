package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.TransactionsStatusesDAO;
import com.appxbuild.matrimony.entity.TransactionsStatuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionsStatusesServiceImpl implements TransactionsStatusesService{

    private TransactionsStatusesDAO transactionsStatusesDAO;

    @Autowired
    public TransactionsStatusesServiceImpl(TransactionsStatusesDAO theTransactionsStatusesDAO){
        transactionsStatusesDAO = theTransactionsStatusesDAO;
    }

    @Override
    public List<TransactionsStatuses> findAll() {
        return transactionsStatusesDAO.findAll();
    }

    @Override
    public TransactionsStatuses findById(int theId) {
        Optional<TransactionsStatuses> result = transactionsStatusesDAO.findById(theId);
        TransactionsStatuses theTransactionsStatuses = null;
        if(result.isPresent()){
            theTransactionsStatuses = result.get();
        }
        else {
            throw new RuntimeException("Transaction Status id is not found " + theId);
        }
        return theTransactionsStatuses;
    }

    @Override
    public TransactionsStatuses save(TransactionsStatuses theTransactionsStatus) {
        return transactionsStatusesDAO.save(theTransactionsStatus);
    }

    @Override
    public void deleteById(int theId) {
        transactionsStatusesDAO.deleteById(theId);
    }
}
