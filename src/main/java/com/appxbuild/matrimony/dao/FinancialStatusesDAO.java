package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.FinancialStatuses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialStatusesDAO extends JpaRepository<FinancialStatuses, Integer> {
}
