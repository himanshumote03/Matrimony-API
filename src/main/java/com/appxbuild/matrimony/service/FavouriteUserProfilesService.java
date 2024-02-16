package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.FavouriteUserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavouriteUserProfilesService {

    List<FavouriteUserProfile> findAll();
    FavouriteUserProfile findById(int theId);
    FavouriteUserProfile save(FavouriteUserProfile theFavouriteUserProfile);
    void deleteById(int theId);
}
