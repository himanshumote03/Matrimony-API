package com.appxbuild.matrimony.rest;


import com.appxbuild.matrimony.entity.PhotosUserProfiles;
import com.appxbuild.matrimony.service.PhotosUserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhotoUserProfilesRestController {

    private PhotosUserProfilesService photosUserProfilesService;

    @Autowired
    public PhotoUserProfilesRestController(PhotosUserProfilesService thePhotosUserProfilesService){
        photosUserProfilesService = thePhotosUserProfilesService;
    }

    // expose "/photosUserProfiles" and return a list of Photo User Profiles
    @GetMapping("/photosUserProfiles")
    public List<PhotosUserProfiles> findAll(){
        return photosUserProfilesService.findAll();
    }

    // add mapping for GET /photosUserProfiles/{photosUserProfileId}
    @GetMapping("/photosUserProfiles/{photosUserProfileId}")
    public PhotosUserProfiles getPhotoUserProfile(@PathVariable int photosUserProfileId){
        PhotosUserProfiles thePhotosUserProfile = photosUserProfilesService.findById(photosUserProfileId);
        if(thePhotosUserProfile == null){
            throw new RuntimeException("Photo User Profile id is not found " + photosUserProfileId);
        }
        return thePhotosUserProfile;
    }

    // add mapping for POST /photosUserProfiles - add Photo User Profile
    @PostMapping("/photosUserProfiles")
    public PhotosUserProfiles addPhotoUserProfile(@RequestBody PhotosUserProfiles thePhotosUserProfiles){
        thePhotosUserProfiles.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        thePhotosUserProfiles.setCreated(localDateTime);
        thePhotosUserProfiles.setModified(localDateTime);
        PhotosUserProfiles newPhoto = photosUserProfilesService.save(thePhotosUserProfiles);
        return newPhoto;
    }

    // add mapping for PUT /photosUserProfiles - update existing Photo User Profile
    @PutMapping("/photosUserProfiles")
    public PhotosUserProfiles updatePhotoUserProfile(@RequestBody PhotosUserProfiles thePhotosUserProfiles){
        LocalDateTime localDateTime = LocalDateTime.now();
        thePhotosUserProfiles.setModified(localDateTime);
        PhotosUserProfiles newPhoto = photosUserProfilesService.save(thePhotosUserProfiles);
        return newPhoto;
    }

    // add mapping for DELETE /photosUserProfiles/{photosUserProfileId} - delete Photo User Profile
    @DeleteMapping("/photosUserProfiles/{photosUserProfileId}")
    public String deletePhotoUserProfile(@PathVariable int photosUserProfileId){
        PhotosUserProfiles thePhotosUserProfile = photosUserProfilesService.findById(photosUserProfileId);
        photosUserProfilesService.deleteById(photosUserProfileId);

        // throw exception if null
        if (thePhotosUserProfile == null){
            throw new RuntimeException("Photo User Profile id is not found - " + photosUserProfileId);
        }
        return "Deleted Photo User Profile id - " + photosUserProfileId;
    }

 }
