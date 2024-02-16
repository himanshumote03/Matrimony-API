package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.AgencyStatusesDAO;
import com.appxbuild.matrimony.entity.AgencyStatuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyStatusesServiceImpl implements AgencyStatusesService {

    private AgencyStatusesDAO agencyStatusesDAO;

    @Autowired
    public AgencyStatusesServiceImpl(AgencyStatusesDAO theAgencyStatusesDAO){
        agencyStatusesDAO = theAgencyStatusesDAO;
    }


    @Override
    public List<AgencyStatuses> findAll() {
        return agencyStatusesDAO.findAll();
    }

    @Override
    public AgencyStatuses findById(int theId) {
        Optional<AgencyStatuses> result = agencyStatusesDAO.findById(theId);

        AgencyStatuses theAgencyStatuses = null;
        if (result.isPresent()){
            theAgencyStatuses = result.get();
        }
        else {
            throw new RuntimeException("Did not find agency status id - " + theId);
        }
        return theAgencyStatuses;
    }

    @Override
    public AgencyStatuses save(AgencyStatuses theAgencyStatuses) {
        return agencyStatusesDAO.save(theAgencyStatuses);
    }


    @Override
    public void deleteById(int theId) {
        agencyStatusesDAO.deleteById(theId);
    }
}
