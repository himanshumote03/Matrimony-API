package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.SmokesDAO;
import com.appxbuild.matrimony.entity.Smokes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmokesServiceImpl implements SmokesService {

    private SmokesDAO smokesDAO;

    public SmokesServiceImpl(SmokesDAO smokesDAO) {
        this.smokesDAO = smokesDAO;
    }

    @Override
    public List<Smokes> findAll() {
        return smokesDAO.findAll();
    }

    @Override
    public Smokes findById(int theId) {
        Optional<Smokes> result = smokesDAO.findById(theId);

        Smokes theSmoke = null;
        if (result.isPresent()){
            theSmoke = result.get();
        }
        else {
            throw new RuntimeException("Did not find Smoke id - " + theId);
        }
        return theSmoke;
    }

    @Override
    public Smokes save(Smokes theSmoke) {
        return smokesDAO.save(theSmoke);
    }


    @Override
    public void deleteById(int theId) {
        smokesDAO.deleteById(theId);
    }
}
