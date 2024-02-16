package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.UserProfilesVisitors;
import com.appxbuild.matrimony.service.UserProfilesVisitorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserProfilesVisitorsRestController {

    private UserProfilesVisitorsService userProfilesVisitorsService;

    @Autowired
    public UserProfilesVisitorsRestController(UserProfilesVisitorsService theUserProfilesVisitorsService){
        userProfilesVisitorsService = theUserProfilesVisitorsService;
    }

    // expose "/userProfilesVisitors" and return a list of UserProfileVisitors
    @GetMapping("/userProfilesVisitors")
    public List<UserProfilesVisitors> findAll() {
        return userProfilesVisitorsService.findAll();
    }

    // add mapping for Get "/userProfilesVisitors/{userProfilesVisitorId}"
    @GetMapping("/userProfilesVisitors/{userProfilesVisitorId}")
    public UserProfilesVisitors getUserProfileVisitor(@PathVariable int userProfilesVisitorId){
        UserProfilesVisitors theUserProfilesVisitor = userProfilesVisitorsService.findById(userProfilesVisitorId);

        if(theUserProfilesVisitor == null){
            throw new RuntimeException("User Profile Visitor is not found" + userProfilesVisitorId);
        }
        return theUserProfilesVisitor;
    }

    // add mapping for POST "/userProfilesVisitors" - add new UserProfileVisitor
    @PostMapping("/userProfilesVisitors")
    public UserProfilesVisitors addUserProfileVisitor(@RequestBody UserProfilesVisitors theUserProfilesVisitors){
        theUserProfilesVisitors.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserProfilesVisitors.setCreated(localDateTime);
        theUserProfilesVisitors.setModified(null);
        UserProfilesVisitors newUserProfile = userProfilesVisitorsService.save(theUserProfilesVisitors);
        return newUserProfile;
    }

    // add mapping for PUT "/userProfilesVisitors" - update existing UserProfileVisitor
    @PutMapping("/userProfilesVisitors")
    public UserProfilesVisitors updateUserProfileVisitor(@RequestBody UserProfilesVisitors theUserProfilesVisitors){
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserProfilesVisitors.setModified(localDateTime);
        UserProfilesVisitors newUserProfile = userProfilesVisitorsService.save(theUserProfilesVisitors);
        return newUserProfile;
    }

    // add mapping for DELETE "/userProfilesVisitors/{userProfilesVisitorId}" - delete UserProfileVisitor
    @DeleteMapping("/userProfilesVisitors/{userProfilesVisitorId}")
    public String deleteUserProfileVisitor(@PathVariable int userProfilesVisitorId){
        UserProfilesVisitors theUserProfilesVisitor = userProfilesVisitorsService.findById(userProfilesVisitorId);
        userProfilesVisitorsService.deleteById(userProfilesVisitorId);

        // throw exception if null
        if (theUserProfilesVisitor == null){
            throw new RuntimeException("User Profile Visitor is not found - " + userProfilesVisitorId);
        }
        return "Deleted User Profile Visitor id - " + userProfilesVisitorId;
    }

}

