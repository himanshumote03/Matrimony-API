package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.FriendsDAO;
import com.appxbuild.matrimony.entity.Friends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendsServiceImpl implements FriendsService{

    private FriendsDAO friendsDAO;

    @Autowired
    public FriendsServiceImpl(FriendsDAO theFriendsDAO){
        friendsDAO = theFriendsDAO;
    }

    @Override
    public List<Friends> findAll() {
        return friendsDAO.findAll();
    }

    @Override
    public Friends findById(int theId) {
        Optional<Friends> result = friendsDAO.findById(theId);
        Friends theFriend = null;
        if(result.isPresent()){
            theFriend = result.get();
        }
        else {
            throw new RuntimeException("Friend id is not found " + theId);
        }
        return theFriend;
    }

    @Override
    public Friends save(Friends theFriends) {
        return friendsDAO.save(theFriends);
    }

    @Override
    public void deleteById(int theId) {
        friendsDAO.deleteById(theId);
    }
}
