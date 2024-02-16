package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.TransactionsStatuses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsStatusesDAO extends JpaRepository<TransactionsStatuses, Integer> {

}
