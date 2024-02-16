package com.appxbuild.matrimony.rest;


import com.appxbuild.matrimony.entity.ThumbnailsUserProfiles;
import com.appxbuild.matrimony.service.ThumbnailsUserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ThumbnailsUserProfilesRestController {

    private ThumbnailsUserProfilesService thumbnailsUserProfilesService;

    @Autowired
    public ThumbnailsUserProfilesRestController(ThumbnailsUserProfilesService theThumbnailsUserProfilesService){
        thumbnailsUserProfilesService = theThumbnailsUserProfilesService;
    }

    // expose "/thumbnailsUserProfiles" and return a list of Thumbnail User Profiles
    @GetMapping("/thumbnailsUserProfiles")
    public List<ThumbnailsUserProfiles> findAll(){
        return thumbnailsUserProfilesService.findAll();
    }

    // add mapping for GET "/thumbnailsUserProfiles/{thumbnailsUserProfileId}"
    @GetMapping("/thumbnailsUserProfiles/{thumbnailsUserProfileId}")
    public ThumbnailsUserProfiles getThumbnailUserProfile(@PathVariable int thumbnailsUserProfileId){
        ThumbnailsUserProfiles theThumbnailsUserProfile = thumbnailsUserProfilesService.findById(thumbnailsUserProfileId);
        if(theThumbnailsUserProfile == null){
            throw new RuntimeException("Thumbnail User Profile id is not found " + thumbnailsUserProfileId);
        }
        return theThumbnailsUserProfile;
    }

    // add mapping for POST "/thumbnailsUserProfiles" - add Thumbnail User Profile
    @PostMapping("/thumbnailsUserProfiles")
    public ThumbnailsUserProfiles addThumbnailUserProfile(@RequestBody ThumbnailsUserProfiles theThumbnailsUserProfiles){
        theThumbnailsUserProfiles.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theThumbnailsUserProfiles.setCreated(localDateTime);
        theThumbnailsUserProfiles.setModified(localDateTime);
        ThumbnailsUserProfiles newThumbnail = thumbnailsUserProfilesService.save(theThumbnailsUserProfiles);
        return newThumbnail;
    }

    // add mapping for PUT "/thumbnailsUserProfiles" - update existing Thumbnail User Profile
    @PutMapping("/thumbnailsUserProfiles")
    public ThumbnailsUserProfiles updateThumbnailUserProfile(@RequestBody ThumbnailsUserProfiles theThumbnailsUserProfiles){
        LocalDateTime localDateTime = LocalDateTime.now();
        theThumbnailsUserProfiles.setModified(localDateTime);
        ThumbnailsUserProfiles newThumbnail = thumbnailsUserProfilesService.save(theThumbnailsUserProfiles);
        return newThumbnail;
    }

    // add mapping for DELETE "/thumbnailsUserProfiles/{thumbnailsUserProfileId}" - delete Thumbnail User Profile
    @DeleteMapping("/thumbnailsUserProfiles/{thumbnailsUserProfileId}")
    public String deleteThumbnailUserProfile(@PathVariable int thumbnailsUserProfileId){
        ThumbnailsUserProfiles theThumbnailsUserProfile = thumbnailsUserProfilesService.findById(thumbnailsUserProfileId);
        thumbnailsUserProfilesService.deleteById(thumbnailsUserProfileId);

        // throw exception if null
        if (theThumbnailsUserProfile == null){
            throw new RuntimeException("Thumbnail User Profile id is not found - " + thumbnailsUserProfileId);
        }
        return "Deleted Thumbnail User Profile id - " + thumbnailsUserProfileId;
    }

 }
