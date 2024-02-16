package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.AgenciesUsersDAO;
import com.appxbuild.matrimony.entity.AgenciesUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenciesUsersServiceImpl implements AgenciesUsersService{

    private AgenciesUsersDAO agenciesUsersDAO;

    @Autowired
    public AgenciesUsersServiceImpl(AgenciesUsersDAO theAgenciesUsersDAO){
        agenciesUsersDAO = theAgenciesUsersDAO;
    }

    @Override
    public List<AgenciesUsers> findAll() {
        return agenciesUsersDAO.findAll();
    }

    @Override
    public AgenciesUsers findById(int theId) {
        Optional<AgenciesUsers> result = agenciesUsersDAO.findById(theId);
        AgenciesUsers theAgenciesUsers = null;
        if(result.isPresent()){
            theAgenciesUsers = result.get();
        }
        else {
            throw new RuntimeException("Agency User id is not found " + theId);
        }
        return theAgenciesUsers;
    }

    @Override
    public AgenciesUsers save(AgenciesUsers theAgenciesUsers) {
        return agenciesUsersDAO.save(theAgenciesUsers);
    }

    @Override
    public void deleteById(int theId) {
        agenciesUsersDAO.deleteById(theId);
    }
}
