package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.UserReferences;
import com.appxbuild.matrimony.service.UserReferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserReferencesRestController {

    private UserReferencesService userReferencesService;

    @Autowired
    public UserReferencesRestController(UserReferencesService theUserReferencesService) {
        userReferencesService = theUserReferencesService;
    }

    // expose "/userReferences" and return a list of userReferences
    @GetMapping("/userReferences")
    public List<UserReferences> findAll() {
        return userReferencesService.findAll();
    }

    // add mapping for GET /userReferences/{userReferenceId}
    @GetMapping("/userReferences/{userReferenceId}")
    public UserReferences getUserReferences(@PathVariable int userReferenceId) {
        UserReferences theUserReferences = userReferencesService.findById(userReferenceId);
        if (theUserReferences == null) {
            throw new RuntimeException("User Reference is not found " + userReferenceId);
        }
        return theUserReferences;
    }

    // add mapping for POST /userReferences - add new userReferences
    @PostMapping("/userReferences")
    public UserReferences addUserReferences(@RequestBody UserReferences theUserReferences) {
        theUserReferences.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserReferences.setCreated(localDateTime);
        theUserReferences.setModified(null);
        UserReferences newUserReference = userReferencesService.save(theUserReferences);
        return newUserReference;
    }

    // add mapping for PUT /userReferences - update existing UserReferences
    @PutMapping("/userReferences")
    public UserReferences updateUserReferences(@RequestBody UserReferences theUserReference) {
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserReference.setModified(localDateTime);
        UserReferences newUserReference = userReferencesService.save(theUserReference);
        return newUserReference;
    }

    // delete mapping for DELETE /userReferences/{userReferenceId}
    @DeleteMapping("/userReferences/{userReferenceId}")
    public String deleteUserReference(@PathVariable int userReferenceId){
        UserReferences theUserReferences = userReferencesService.findById(userReferenceId);

        // throw exception if null
        if(theUserReferences == null){
            throw new RuntimeException("User Reference is not found - " + userReferenceId);
        }
        userReferencesService.deleteById(userReferenceId);
        return "Deleted User id - " + userReferenceId;
    }
}