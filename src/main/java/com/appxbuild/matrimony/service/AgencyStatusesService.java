package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.AgencyStatuses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgencyStatusesService {

    List<AgencyStatuses> findAll();
    AgencyStatuses findById(int theId);
    AgencyStatuses save(AgencyStatuses theAgencyStatuses);
    void deleteById(int theId);

}
