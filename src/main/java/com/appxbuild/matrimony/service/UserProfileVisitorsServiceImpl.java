package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.UserProfilesVisitorsDAO;
import com.appxbuild.matrimony.entity.UserProfilesVisitors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileVisitorsServiceImpl implements UserProfilesVisitorsService{

    private UserProfilesVisitorsDAO userProfilesVisitorsDAO;

    @Autowired
    public UserProfileVisitorsServiceImpl(UserProfilesVisitorsDAO theUserProfilesVisitorsDAO){
        userProfilesVisitorsDAO = theUserProfilesVisitorsDAO;
    }

    @Override
    public List<UserProfilesVisitors> findAll() {
        return userProfilesVisitorsDAO.findAll();
    }

    @Override
    public UserProfilesVisitors findById(int theId) {
        Optional<UserProfilesVisitors> result = userProfilesVisitorsDAO.findById(theId);
        UserProfilesVisitors theUserProfilesVisitor = null;
        if(result.isPresent()){
            theUserProfilesVisitor = result.get();
        }
        else {
            throw new RuntimeException("User Profile Visitor id is not found " + theId);
        }
        return theUserProfilesVisitor;
    }

    @Override
    public UserProfilesVisitors save(UserProfilesVisitors theUserProfilesVisitors) {
        return userProfilesVisitorsDAO.save(theUserProfilesVisitors);
    }

    @Override
    public void deleteById(int theId) {
        userProfilesVisitorsDAO.deleteById(theId);
    }
}
