package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.FavouriteUserProfileDAO;
import com.appxbuild.matrimony.entity.FavouriteUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouriteUserProfilesServiceImpl implements FavouriteUserProfilesService{

    private FavouriteUserProfileDAO favouriteUserProfileDAO;

    @Autowired
    public FavouriteUserProfilesServiceImpl(FavouriteUserProfileDAO theFavouriteUserProfileDAO){
        favouriteUserProfileDAO = theFavouriteUserProfileDAO;
    }

    @Override
    public List<FavouriteUserProfile> findAll() {
        return favouriteUserProfileDAO.findAll();
    }

    @Override
    public FavouriteUserProfile findById(int theId) {
        Optional<FavouriteUserProfile> result = favouriteUserProfileDAO.findById(theId);
        FavouriteUserProfile theFavouriteUserProfile = null;
        if(result.isPresent()){
            theFavouriteUserProfile = result.get();
        }
        else {
            throw new RuntimeException("Favourite User Profile id is not found " + theId);
        }
        return theFavouriteUserProfile;
    }

    @Override
    public FavouriteUserProfile save(FavouriteUserProfile theFavouriteUserProfile) {
        return favouriteUserProfileDAO.save(theFavouriteUserProfile);
    }

    @Override
    public void deleteById(int theId) {
        favouriteUserProfileDAO.deleteById(theId);
    }
}
