package com.appxbuild.matrimony.service;


import com.appxbuild.matrimony.dao.UserReferencesDAO;
import com.appxbuild.matrimony.entity.UserReferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserReferencesServiceImpl implements UserReferencesService{

    private UserReferencesDAO userReferencesDAO;

    @Autowired
    public UserReferencesServiceImpl(UserReferencesDAO theUserReferencesDAO){
        userReferencesDAO = theUserReferencesDAO;
    }

    @Override
    public List<UserReferences> findAll() {
        return userReferencesDAO.findAll();
    }

    @Override
    public UserReferences findById(int theId) {
        Optional<UserReferences> result = userReferencesDAO.findById(theId);

        UserReferences theUerReferences = null;
        if (result.isPresent()){
            theUerReferences = result.get();
        }
        else {
            throw new RuntimeException("Did not find user references id - " + theId);
        }
        return theUerReferences;
    }

    @Override
    public UserReferences save(UserReferences theUserReferences) {
        return userReferencesDAO.save(theUserReferences);
    }

    @Override
    public void deleteById(int theId) {
        userReferencesDAO.deleteById(theId);
    }
}
