package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.UserProfilesVisitors;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserProfilesVisitorsService {

    List<UserProfilesVisitors> findAll();
    UserProfilesVisitors findById(int theId);
    UserProfilesVisitors save(UserProfilesVisitors theUserProfilesVisitors);
    void deleteById(int theId);
}
