package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.UserProfileStatuses;
import com.appxbuild.matrimony.service.UserProfileStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserProfileStatusesRestController {

    private UserProfileStatusesService userProfileStatusesService;

    @Autowired
    public UserProfileStatusesRestController(UserProfileStatusesService theUserProfileStatusesService){
        userProfileStatusesService = theUserProfileStatusesService;
    }

    // expose "/userProfileStatuses" and return a list of UserProfileStatuses
    @GetMapping("/userProfileStatuses")
    public List<UserProfileStatuses> findAll(){
        return userProfileStatusesService.findAll();
    }

}
