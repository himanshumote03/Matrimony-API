package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.FriendUserProfilesDAO;
import com.appxbuild.matrimony.entity.FriendsUserProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendUserProfilesServiceImpl implements FriendsUserProfilesService{

    private FriendUserProfilesDAO friendUserProfilesDAO;

    @Autowired
    public FriendUserProfilesServiceImpl(FriendUserProfilesDAO theFriendUserProfilesDAO){
        friendUserProfilesDAO = theFriendUserProfilesDAO;
    }

    @Override
    public List<FriendsUserProfiles> findAll() {
        return friendUserProfilesDAO.findAll();
    }

    @Override
    public FriendsUserProfiles findById(int theId) {
        Optional<FriendsUserProfiles> result = friendUserProfilesDAO.findById(theId);
        FriendsUserProfiles theFriendsUserProfile = null;
        if(result.isPresent()){
            theFriendsUserProfile = result.get();
        }
        else {
            throw new RuntimeException("Friend User Profile id is not found " + theId);
        }
        return theFriendsUserProfile;
    }

    @Override
    public FriendsUserProfiles save(FriendsUserProfiles theFriendsUserProfiles) {
        return friendUserProfilesDAO.save(theFriendsUserProfiles);
    }

    @Override
    public void deleteById(int theId) {
        friendUserProfilesDAO.deleteById(theId);
    }
}
