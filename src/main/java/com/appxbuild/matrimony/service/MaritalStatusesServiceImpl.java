package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.MaritalStatusesDAO;
import com.appxbuild.matrimony.entity.MaritalStatuses;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaritalStatusesServiceImpl implements MaritalStatusesService {

    private MaritalStatusesDAO maritalStatusesDAO;

    public MaritalStatusesServiceImpl(MaritalStatusesDAO maritalStatusesDAO) {
        this.maritalStatusesDAO = maritalStatusesDAO;
    }

    @Override
    public List<MaritalStatuses> findAll() {
        return maritalStatusesDAO.findAll();
    }

    @Override
    public MaritalStatuses findById(int theId) {
        Optional<MaritalStatuses> result = maritalStatusesDAO.findById(theId);
        MaritalStatuses theMaritalStatus = null;
        if(result.isPresent()){
            theMaritalStatus = result.get();
        }
        else {
            throw new RuntimeException("Marital Status id id not found " + theId);
        }
        return theMaritalStatus;
    }

    @Override
    public MaritalStatuses save(MaritalStatuses theMaritalStatuses) {
        return maritalStatusesDAO.save(theMaritalStatuses);
    }

    @Override
    public void deleteById(int theId) {
        maritalStatusesDAO.deleteById(theId);
    }
}
