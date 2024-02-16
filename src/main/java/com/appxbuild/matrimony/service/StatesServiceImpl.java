package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.StatesDAO;
import com.appxbuild.matrimony.entity.States;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatesServiceImpl implements StatesService {

    private StatesDAO statesDAO;

    public StatesServiceImpl(StatesDAO statesDAO) {
        this.statesDAO = statesDAO;
    }

    @Override
    public List<States> findAll() {
        return statesDAO.findAll();
    }

    @Override
    public States findById(int theId) {
        Optional<States> result = statesDAO.findById(theId);

        States states = null;
        if (result.isPresent()) {
            states = result.get();
        }
        else {
            throw new RuntimeException("Did not find State id: "+ theId);
        }

        return states;
    }

    @Override
    public States save(States states) {
        return statesDAO.save(states);
    }

    @Override
    public void delete(int theId) {
        statesDAO.deleteById(theId);
    }
}
