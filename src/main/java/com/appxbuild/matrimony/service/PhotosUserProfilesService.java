package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.PhotosUserProfiles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhotosUserProfilesService {

    List<PhotosUserProfiles> findAll();
    PhotosUserProfiles findById(int theId);
    PhotosUserProfiles save(PhotosUserProfiles thePhotosUserProfiles);
    void deleteById(int theId);

}
