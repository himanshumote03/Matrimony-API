package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.PhotosUserProfilesDAO;
import com.appxbuild.matrimony.entity.PhotosUserProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotosUserProfilesServiceImpl implements PhotosUserProfilesService{

    private PhotosUserProfilesDAO photosUserProfilesDAO;

    @Autowired
    public PhotosUserProfilesServiceImpl(PhotosUserProfilesDAO thePhotosUserProfilesDAO){
        photosUserProfilesDAO = thePhotosUserProfilesDAO;
    }

    @Override
    public List<PhotosUserProfiles> findAll() {
        return photosUserProfilesDAO.findAll();
    }

    @Override
    public PhotosUserProfiles findById(int theId) {
        Optional<PhotosUserProfiles> result = photosUserProfilesDAO.findById(theId);
        PhotosUserProfiles thePhotosUserProfile = null;
        if(result.isPresent()){
            thePhotosUserProfile = result.get();
        }
        else {
            throw  new RuntimeException("Photo User Profile id is not found " + theId);
        }
        return thePhotosUserProfile;
    }

    @Override
    public PhotosUserProfiles save(PhotosUserProfiles thePhotosUserProfiles) {
        return photosUserProfilesDAO.save(thePhotosUserProfiles);
    }

    @Override
    public void deleteById(int theId) {
        photosUserProfilesDAO.deleteById(theId);
    }
}
