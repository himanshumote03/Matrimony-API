package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.FriendsUserProfiles;
import com.appxbuild.matrimony.service.FriendsUserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class FriendsUserProfilesRestController {

    private FriendsUserProfilesService friendsUserProfilesService;

    @Autowired
    public FriendsUserProfilesRestController(FriendsUserProfilesService theFriendsUserProfilesService){
        friendsUserProfilesService = theFriendsUserProfilesService;
    }

    // expose "/friendsUserProfiles" and return a list of Friend User Profiles
    @GetMapping("/friendsUserProfiles")
    public List<FriendsUserProfiles> findAll() {
        return friendsUserProfilesService.findAll();
    }

    // add mapping for Get "/friendsUserProfiles/{friendsUserProfileId}"
    @GetMapping("/friendsUserProfiles/{friendsUserProfileId}")
    public FriendsUserProfiles getFriendUserProfile(@PathVariable int friendsUserProfileId){
        FriendsUserProfiles theFriendUserProfile = friendsUserProfilesService.findById(friendsUserProfileId);

        if(theFriendUserProfile == null){
            throw new RuntimeException("Friend User Profile id is not found" + friendsUserProfileId);
        }
        return theFriendUserProfile;
    }

    // add mapping for POST "/friendsUserProfiles" - add new list of Friend User Profile
    @PostMapping("/friendsUserProfiles")
    public FriendsUserProfiles addFriendUserProfile(@RequestBody FriendsUserProfiles theFriendUserProfiles){
        theFriendUserProfiles.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theFriendUserProfiles.setCreated(localDateTime);
        theFriendUserProfiles.setModified(null);
        FriendsUserProfiles newFriendUserProfile = friendsUserProfilesService.save(theFriendUserProfiles);
        return newFriendUserProfile;
    }

    // add mapping for PUT "/friendsUserProfiles" - update existing list of Friend User Profile
    @PutMapping("/friendsUserProfiles")
    public FriendsUserProfiles updateFriendUserProfile(@RequestBody FriendsUserProfiles theFriendUserProfiles){
        LocalDateTime localDateTime = LocalDateTime.now();
        theFriendUserProfiles.setModified(localDateTime);
        FriendsUserProfiles newFriendUserProfile = friendsUserProfilesService.save(theFriendUserProfiles);
        return newFriendUserProfile;
    }

    // add mapping for DELETE "/friendsUserProfiles/{friendsUserProfileId}" - delete list of Friend User Profile
    @DeleteMapping("/friendsUserProfiles/{friendsUserProfileId}")
    public String deleteFriendUserProfile(@PathVariable int friendsUserProfileId){
        FriendsUserProfiles theFriendUserProfile = friendsUserProfilesService.findById(friendsUserProfileId);
        friendsUserProfilesService.deleteById(friendsUserProfileId);

        // throw exception if null
        if (theFriendUserProfile == null){
            throw new RuntimeException("Friend User Profile id is not found - " + friendsUserProfileId);
        }
        return "Deleted Friend User Profile id - " + friendsUserProfileId;
    }

}

