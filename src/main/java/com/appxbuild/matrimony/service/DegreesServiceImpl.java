package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.DegreesDAO;
import com.appxbuild.matrimony.entity.Degrees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DegreesServiceImpl implements DegreesService{
    private DegreesDAO degreesDAO;

    @Autowired
    public DegreesServiceImpl(DegreesDAO theDegreesDAO){
        degreesDAO = theDegreesDAO;
    }

    @Override
    public List<Degrees> findAll() {
        return degreesDAO.findAll();
    }

    @Override
    public Degrees findById(int theId) {
        Optional<Degrees> result = degreesDAO.findById(theId);
        Degrees theDegree = null;
        if(result.isPresent()){
            theDegree = result.get();
        }
        else {
            throw new RuntimeException("Did not find degree id - " + theId);
        }
        return theDegree;
    }

    @Override
    public Degrees save(Degrees theDegrees) {
        return degreesDAO.save(theDegrees);
    }

    @Override
    public void deleteById(int theId) {
        degreesDAO.deleteById(theId);
    }
}
