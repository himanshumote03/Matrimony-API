package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.ComplexionsDAO;
import com.appxbuild.matrimony.entity.Complexions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplexionsServiceImpl implements ComplexionsService {

    private ComplexionsDAO complexionsDAO;

    public ComplexionsServiceImpl(ComplexionsDAO complexionsDAO) {
        this.complexionsDAO = complexionsDAO;
    }

    @Override
    public List<Complexions> findAll() {
        return complexionsDAO.findAll();
    }

    @Override
    public Complexions findById(int theId) {
        Optional<Complexions> result = complexionsDAO.findById(theId);
        Complexions theComplexion = null;
        if (result.isPresent()){
            theComplexion = result.get();
        }
        else {
            throw new RuntimeException("Did not find complexion id - " + theId);
        }
        return theComplexion;
    }

    @Override
    public Complexions save(Complexions theComplexions) {
        return complexionsDAO.save(theComplexions);
    }

    @Override
    public void deleteById(int theId) {
        complexionsDAO.deleteById(theId);
    }
}
