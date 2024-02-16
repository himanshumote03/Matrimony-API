package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsDAO extends JpaRepository<Transactions, Integer> {
}
