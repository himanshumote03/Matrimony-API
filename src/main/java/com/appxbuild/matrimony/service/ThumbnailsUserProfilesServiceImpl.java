package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.ThumbnailsUserProfilesDAO;
import com.appxbuild.matrimony.entity.ThumbnailsUserProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThumbnailsUserProfilesServiceImpl implements ThumbnailsUserProfilesService {

    private ThumbnailsUserProfilesDAO thumbnailsUserProfilesDAO;

    @Autowired
    public ThumbnailsUserProfilesServiceImpl(ThumbnailsUserProfilesDAO theThumbnailsUserProfilesDAO){
        thumbnailsUserProfilesDAO = theThumbnailsUserProfilesDAO;
    }


    @Override
    public List<ThumbnailsUserProfiles> findAll() {
        return thumbnailsUserProfilesDAO.findAll();
    }

    @Override
    public ThumbnailsUserProfiles findById(int theId) {
        Optional<ThumbnailsUserProfiles> result = thumbnailsUserProfilesDAO.findById(theId);

        ThumbnailsUserProfiles theThumbnailsUserProfile = null;
        if (result.isPresent()){
            theThumbnailsUserProfile = result.get();
        }
        else {
            throw new RuntimeException("Did not find Thumbnail User Profile id - " + theId);
        }
        return theThumbnailsUserProfile;
    }

    @Override
    public ThumbnailsUserProfiles save(ThumbnailsUserProfiles theThumbnailsUserProfiles) {
        return thumbnailsUserProfilesDAO.save(theThumbnailsUserProfiles);
    }


    @Override
    public void deleteById(int theId) {
        thumbnailsUserProfilesDAO.deleteById(theId);
    }
}
