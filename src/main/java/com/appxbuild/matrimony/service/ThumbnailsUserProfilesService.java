package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.ThumbnailsUserProfiles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThumbnailsUserProfilesService {

    List<ThumbnailsUserProfiles> findAll();
    ThumbnailsUserProfiles findById(int theId);
    ThumbnailsUserProfiles save(ThumbnailsUserProfiles theThumbnailsUserProfiles);
    void deleteById(int theId);

}
