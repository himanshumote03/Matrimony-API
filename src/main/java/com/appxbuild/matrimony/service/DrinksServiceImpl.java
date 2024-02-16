package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.DrinksDAO;
import com.appxbuild.matrimony.entity.Drinks;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinksServiceImpl implements DrinksService {

    private DrinksDAO drinksDAO;

    public DrinksServiceImpl(DrinksDAO drinksDAO) {
        this.drinksDAO = drinksDAO;
    }

    @Override
    public List<Drinks> findAll() {
        return drinksDAO.findAll();
    }


    @Override
    public Drinks findById(int theId) {
        Optional<Drinks> result = drinksDAO.findById(theId);

        Drinks theDrink = null;
        if (result.isPresent()){
            theDrink = result.get();
        }
        else {
            throw new RuntimeException("Did not find drink id - " + theId);
        }
        return theDrink;
    }

    @Override
    public Drinks save(Drinks theAgencies) {
        return drinksDAO.save(theAgencies);
    }


    @Override
    public void deleteById(int theId) {
        drinksDAO.deleteById(theId);
    }
}
