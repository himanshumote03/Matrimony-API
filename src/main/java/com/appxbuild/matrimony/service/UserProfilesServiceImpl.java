package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.UserProfilesDAO;
import com.appxbuild.matrimony.entity.UserProfiles;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfilesServiceImpl implements UserProfilesService{

    private UserProfilesDAO userProfilesDAO;

    public UserProfilesServiceImpl(UserProfilesDAO userProfilesDAO) {
        this.userProfilesDAO = userProfilesDAO;
    }


    @Override
    public List<UserProfiles> findAll() {
        return userProfilesDAO.findAll();
    }

    @Override
    public UserProfiles findById(int theId) {

        Optional<UserProfiles> result = userProfilesDAO.findById(theId);

        UserProfiles userProfiles = null;
        if (result.isPresent()) {
            userProfiles = result.get();
        }
        else {
            throw new RuntimeException("Did not find Id: " + theId);
        }

        return userProfiles;
    }

    @Override
    public UserProfiles save(UserProfiles userProfiles) {
        return userProfilesDAO.save(userProfiles);
    }

    @Override
    public void delete(int theId) {
        userProfilesDAO.deleteById(theId);
    }


}
