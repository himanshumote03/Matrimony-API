package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.UserRelativesDAO;
import com.appxbuild.matrimony.entity.UserRelatives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRelativesServiceImpl implements UserRelativesService{

    private UserRelativesDAO userRelativesDAO;

    @Autowired
    public UserRelativesServiceImpl(UserRelativesDAO theUserRelativesDAO){
        userRelativesDAO = theUserRelativesDAO;
    }
    @Override
    public List<UserRelatives> findAll() {
        return userRelativesDAO.findAll();
    }

    @Override
    public UserRelatives findById(int theId) {
        Optional<UserRelatives> result = userRelativesDAO.findById(theId);

        UserRelatives theUserRelatives = null;
        if (result.isPresent()){
            theUserRelatives = result.get();
        }
        else {
            throw new RuntimeException("Did not find user relative id - " + theId);
        }
        return theUserRelatives;
    }




    @Override
    public UserRelatives save(UserRelatives theUserRelatives) {
        return userRelativesDAO.save(theUserRelatives);
    }

    @Override
    public void deleteById(int theId) {
        userRelativesDAO.deleteById(theId);
    }
}
