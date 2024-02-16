package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.HeightsDAO;
import com.appxbuild.matrimony.entity.Heights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeightsServiceImpl implements HeightsService {
    private HeightsDAO heightsDAO;

    @Autowired
    public HeightsServiceImpl(HeightsDAO theHeightsDAO){
        heightsDAO = theHeightsDAO;
    }

    @Override
    public List<Heights> findAll() {
        return heightsDAO.findAll();
    }

    @Override
    public Heights findById(int theId) {
        Optional<Heights> result = heightsDAO.findById(theId);
        Heights theHeight = null;
        if (result.isPresent()){
            theHeight = result.get();
        }
        else {
            throw new RuntimeException("Did not find Gotras id - " + theId);
        }
        return theHeight;
    }

    @Override
    public Heights save(Heights theHeights) {
        return heightsDAO.save(theHeights);
    }

    @Override
    public void deleteById(int theId) {
        heightsDAO.deleteById(theId);
    }
}
