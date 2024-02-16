package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.GendersDAO;
import com.appxbuild.matrimony.entity.Genders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GendersServiceImpl implements GendersService {

    private GendersDAO gendersDAO;

    public GendersServiceImpl(GendersDAO gendersDAO) {
        this.gendersDAO = gendersDAO;
    }

    @Override
    public List<Genders> findAll() {
        return gendersDAO.findAll();
    }

    @Override
    public Genders findById(int theId) {
        Optional<Genders> result = gendersDAO.findById(theId);
        Genders theGender = null;
        if (result.isPresent()){
            theGender = result.get();
        }
        else {
            throw new RuntimeException("Did not find Genders id - " + theId);
        }
        return theGender;
    }

    @Override
    public Genders save(Genders theGenders) {
        return gendersDAO.save(theGenders);
    }

    @Override
    public void deleteById(int theId) {
        gendersDAO.deleteById(theId);
    }
}
