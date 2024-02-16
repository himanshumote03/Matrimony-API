package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.BodyTypesDAO;
import com.appxbuild.matrimony.entity.BodyTypes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodyTypesServiceImpl implements BodyTypesService {

    private BodyTypesDAO bodyTypesDAO;

    public BodyTypesServiceImpl(BodyTypesDAO bodyTypesDAO) {
        this.bodyTypesDAO = bodyTypesDAO;
    }

    @Override
    public List<BodyTypes> findAll() {
        return bodyTypesDAO.findAll();
    }

    @Override
    public BodyTypes findById(int theId) {
        Optional<BodyTypes> result = bodyTypesDAO.findById(theId);
        BodyTypes theBodyType = null;
        if(result.isPresent()){
            theBodyType = result.get();
        }
        else {
            throw new RuntimeException("Body Type id is not found " + theId);
        }
        return null;
    }

    @Override
    public BodyTypes save(BodyTypes theBodyTypes) {
        return bodyTypesDAO.save(theBodyTypes);
    }

    @Override
    public void deleteById(int theId) {
        bodyTypesDAO.deleteById(theId);
    }
}
