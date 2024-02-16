package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.FinancialStatuses;

import java.util.List;

public interface FinancialStatusesService {
    List<FinancialStatuses> findAll();
    FinancialStatuses findById(int theId);
    FinancialStatuses save(FinancialStatuses theFinancialStatuses);
    void deleteById(int theId);
}
