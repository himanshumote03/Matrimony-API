package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Agencies;
import com.appxbuild.matrimony.entity.AgencyStatuses;

import java.util.List;

public interface AgencyService {

    // Agencies
    List<Agencies> findAll();

    Agencies findById(int theId);

    Agencies save(Agencies agencies);

    void delete(int theId);

}
