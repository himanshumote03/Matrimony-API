package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.UserProfiles;
import com.appxbuild.matrimony.service.UserProfilesService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserProfilesRestController {

    private UserProfilesService userProfilesService;

    public UserProfilesRestController(UserProfilesService userProfilesService) {
        this.userProfilesService = userProfilesService;
    }


    // "/userProfiles" -> get all userProfiles
    @GetMapping("/userProfiles")
    public List<UserProfiles> findAll() {
        return userProfilesService.findAll();
    }

    // "/userProfiles{userProfileId}" -> get a userProfile with specific id
    @GetMapping("/userProfiles/{userProfileId}")
    public UserProfiles getUserProfile(@PathVariable int userProfileId) {
        UserProfiles userProfiles = userProfilesService.findById(userProfileId);

        if (userProfiles == null) {
            throw new RuntimeException("Did not find id: "+userProfileId);
        }

        return userProfiles;
    }


    // "/userProfiles" -> add new userProfile
    @PostMapping("/userProfiles")
    public UserProfiles addUserProfile(@RequestBody UserProfiles userProfiles) {

        userProfiles.setId(0);
        LocalDateTime dt = LocalDateTime.now();
        userProfiles.setCreated(dt);
        userProfiles.setModified(null);

        UserProfiles dbUserProfile = userProfilesService.save(userProfiles);

        return dbUserProfile;
    }

    // "/userProfiles" -> update userProfile
    @PutMapping("/userProfiles")
    public UserProfiles updateUserProfile(@RequestBody UserProfiles userProfiles) {
        LocalDateTime dt = LocalDateTime.now();
        userProfiles.setModified(dt);

        UserProfiles dbUserProfile = userProfilesService.save(userProfiles);
        return dbUserProfile;
    }

    // "/userProfiles{userProfileId}" -> delete userProfile
    @DeleteMapping("/userProfiles/{userProfileId}")
    public void delete(@PathVariable int userProfileId) {
        UserProfiles userProfiles = userProfilesService.findById(userProfileId);

        if (userProfiles == null) {
            throw new RuntimeException("Did not find id: " + userProfileId);
        }

        userProfilesService.delete(userProfileId);
    }

}
