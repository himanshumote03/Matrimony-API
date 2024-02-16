package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Friends;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriendsService {

    List<Friends> findAll();
    Friends findById(int theId);
    Friends save(Friends theFriends);
    void deleteById(int theId);
}
