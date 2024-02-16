package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.AgencyDAO;
import com.appxbuild.matrimony.dao.AgencyStatusesDAO;
import com.appxbuild.matrimony.entity.Agencies;
import com.appxbuild.matrimony.entity.AgencyStatuses;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyServiceImpl implements AgencyService {

     private AgencyDAO agencyDAO;
     private AgencyStatusesDAO agencyStatusesDAO;

     public AgencyServiceImpl (AgencyDAO agencyDAO, AgencyStatusesDAO agencyStatusesDAO) {
         this.agencyDAO = agencyDAO;
         this.agencyStatusesDAO = agencyStatusesDAO;
     }



     @Override
     public List<Agencies> findAll() {
         return agencyDAO.findAll();
     }

    @Override
    public Agencies findById(int theId) {
        Optional<Agencies> result = agencyDAO.findById(theId);

        Agencies agencies = null;
        if (result.isPresent()) {
            agencies = result.get();
        }
        else {
            throw new RuntimeException("Did not find Agency id: " + theId);
        }

        return agencies;
    }

    @Override
    public Agencies save(Agencies agencies) {
        return agencyDAO.save(agencies);
    }

    @Override
    public void delete(int theId) {
         AgencyStatuses ag = new AgencyStatuses();
         ag.setAgencies(null);
         agencyDAO.deleteById(theId);
    }

}
