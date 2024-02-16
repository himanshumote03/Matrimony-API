package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.TransactionsStatuses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionsStatusesService {

    List<TransactionsStatuses> findAll();
    TransactionsStatuses findById(int theId);
    TransactionsStatuses save(TransactionsStatuses theTransactionsStatus);

    void deleteById(int theId);

}
