package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Transactions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionsService {

    List<Transactions> findAll();
    Transactions findById(int theId);
    Transactions save(Transactions theTransactions);
    void deleteById(int theId);
}
