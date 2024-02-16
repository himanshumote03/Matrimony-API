package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.FriendsUserProfiles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriendsUserProfilesService {

    List<FriendsUserProfiles> findAll();
    FriendsUserProfiles findById(int theId);
    FriendsUserProfiles save(FriendsUserProfiles theFriendsUserProfiles);
    void deleteById(int theId);

}
