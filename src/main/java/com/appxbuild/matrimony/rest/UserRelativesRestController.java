package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.UserRelatives;
import com.appxbuild.matrimony.service.UserRelativesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRelativesRestController {

    private UserRelativesService userRelativesService;

    @Autowired
    public UserRelativesRestController(UserRelativesService theUserRelativesService){
        userRelativesService = theUserRelativesService;
    }

    // expose "/relatives" and return a list of userRelatives
    @GetMapping("/relatives")
    public List<UserRelatives> findAll(){
        return userRelativesService.findAll();
    }

    // add mapping for Get /relatives/{relativeId}
    @GetMapping("/relatives/{relativeId}")
    public UserRelatives getUserRelative(@PathVariable int relativeId){
        UserRelatives theUserRelatives = userRelativesService.findById(relativeId);

        if(theUserRelatives == null){
            throw new RuntimeException("User Relative is not found" + relativeId);
        }
        return theUserRelatives;
    }

    // add mapping for POST /relatives - add new userRelative
    @PostMapping("/relatives")
    public UserRelatives addUserRelative(@RequestBody UserRelatives theUserRelatives){
        theUserRelatives.setId(0);
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        theUserRelatives.setCreated(timestamp);
        theUserRelatives.setModified(null);
        UserRelatives newUserRelative = userRelativesService.save(theUserRelatives);
        return newUserRelative;
    }

    // add mapping for PUT /relatives - update existing UserRelative
    @PutMapping("/relatives")
    public UserRelatives updateUserRelative(@RequestBody UserRelatives theUserRelatives){
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        theUserRelatives.setModified(timestamp);
        UserRelatives newUserRelative = userRelativesService.save(theUserRelatives);
        return newUserRelative;
    }

    // add mapping for DELETE /relatives/{relativeId} - delete userRelative
    @DeleteMapping("/relatives/{relativeId}")
    public String deleteUserRelative(@PathVariable int relativeId){
        UserRelatives theUserRelatives = userRelativesService.findById(relativeId);
        userRelativesService.deleteById(relativeId);

        // throw exception if null
        if (theUserRelatives == null){
            throw new RuntimeException("User Relative is not found - " + relativeId);
        }
        return "Deleted User Relative id - " + relativeId;
    }
}
