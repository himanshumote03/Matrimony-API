package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.UserProfileStatusesDAO;
import com.appxbuild.matrimony.entity.UserProfileStatuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileStatusesServiceImpl implements UserProfileStatusesService {

    private UserProfileStatusesDAO userProfileStatusesDAO;

    @Autowired
    public UserProfileStatusesServiceImpl(UserProfileStatusesDAO theUserProfileStatusesDAO){
        userProfileStatusesDAO = theUserProfileStatusesDAO;
    }


    @Override
    public List<UserProfileStatuses> findAll() {
        return userProfileStatusesDAO.findAll();
    }

    @Override
    public UserProfileStatuses findById(int theId) {
        Optional<UserProfileStatuses> result = userProfileStatusesDAO.findById(theId);

        UserProfileStatuses theUserProfileStatus = null;
        if (result.isPresent()){
            theUserProfileStatus = result.get();
        }
        else {
            throw new RuntimeException("Did not find user profile status id - " + theId);
        }
        return theUserProfileStatus;
    }

    @Override
    public UserProfileStatuses save(UserProfileStatuses theUserProfileStatuses) {
        return userProfileStatusesDAO.save(theUserProfileStatuses);
    }


    @Override
    public void deleteById(int theId) {
        userProfileStatusesDAO.deleteById(theId);
    }
}
