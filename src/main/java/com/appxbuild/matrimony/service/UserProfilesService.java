package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.UserProfiles;

import java.util.List;

public interface UserProfilesService {

    List<UserProfiles> findAll();

    UserProfiles findById(int theId);

    UserProfiles save(UserProfiles userProfiles);

    void delete(int theId);
}
