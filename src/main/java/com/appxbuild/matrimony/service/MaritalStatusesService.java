package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.MaritalStatuses;

import java.util.List;

public interface MaritalStatusesService {
    List<MaritalStatuses> findAll();

    MaritalStatuses findById(int theId);

    MaritalStatuses save(MaritalStatuses theMaritalStatuses);

    void deleteById(int theId);
}
