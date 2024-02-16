package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.UserStatuses;
import com.appxbuild.matrimony.service.UserStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserStatusesRestController {

    private UserStatusesService userStatusesService;

    // expose "/userStatuses" and return a list of userStatus
    @GetMapping("/userStatuses")
    public List<UserStatuses> findAll(){
        return userStatusesService.findAll();
    }

    // add mapping for Get /userStatuses/{userStatuseId}
    @GetMapping("/userStatuses/{userStatuseId}")
    public UserStatuses getUserStatus(@PathVariable int userStatuseId){
        UserStatuses theUserStatuses = userStatusesService.findById(userStatuseId);

        if(theUserStatuses == null){
            throw new RuntimeException("User Relative is not found" + userStatuseId);
        }
        return theUserStatuses;
    }

     //add mapping for POST /userStatuses - add new userStatus
    @PostMapping("/userStatuses")
    public UserStatuses addUserStatus(@RequestBody UserStatuses theUserStatuses){
        theUserStatuses.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserStatuses.setCreated(localDateTime);
        theUserStatuses.setModified(null);
        UserStatuses newUserRelative = userStatusesService.save(theUserStatuses);
        return newUserRelative;
    }

    // add mapping for PUT /userStatuses - update existing UserStatus
    @PutMapping("/userStatuses")
    public UserStatuses updateUserStatus(@RequestBody UserStatuses theUserStatuses){
        LocalDateTime localDateTime = LocalDateTime.now();
        theUserStatuses.setModified(localDateTime);
        UserStatuses newUserRelative = userStatusesService.save(theUserStatuses);
        return newUserRelative;
    }

    // add mapping for DELETE /userStatuses/{userStatuseId} - delete userStatus
    @DeleteMapping("/userStatuses/{userStatuseId}")
    public String deleteUserStatus(@PathVariable int userStatuseId){
        UserStatuses theUserStatuses = userStatusesService.findById(userStatuseId);

        // throw exception if null
        if (theUserStatuses == null){
            throw new RuntimeException("User Status id is not found - " + userStatuseId);
        }
        userStatusesService.deleteById(userStatuseId);
        return "Deleted User Status id - " + userStatuseId;
    }
}
