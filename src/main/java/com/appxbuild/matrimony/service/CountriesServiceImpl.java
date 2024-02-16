package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.CountriesDAO;
import com.appxbuild.matrimony.entity.Countries;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountriesServiceImpl implements CountriesService{

    private CountriesDAO countriesDAO;

    public CountriesServiceImpl(CountriesDAO countriesDAO) {
        this.countriesDAO = countriesDAO;
    }

    @Override
    public List<Countries> findAll() {
        return countriesDAO.findAll();
    }

    @Override
    public Countries findById(int theId) {

        Optional<Countries> result = countriesDAO.findById(theId);

        Countries countries = null;
        if (result.isPresent()) {
            countries = result.get();
        }
        else {
            throw new RuntimeException("Did not find country id: " + theId);
        }

        return countries;
    }

    @Override
    public Countries save(Countries countries) {
        return countriesDAO.save(countries);
    }

    @Override
    public void delete(int theId) {
        countriesDAO.deleteById(theId);
    }
}
