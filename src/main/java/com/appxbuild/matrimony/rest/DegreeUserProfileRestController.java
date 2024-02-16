package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.DegreeUserProfiles;
import com.appxbuild.matrimony.service.DegreeUserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DegreeUserProfileRestController {

    private DegreeUserProfilesService degreeUserProfilesService;

    @Autowired
    public DegreeUserProfileRestController(DegreeUserProfilesService theDegreeUserProfilesService){
        degreeUserProfilesService = theDegreeUserProfilesService;
    }

    // expose GET "/degreeUserProfiles" to get a list of degree user profiles
    @GetMapping("degreeUserProfiles")
    public List<DegreeUserProfiles> findALl(){
        return degreeUserProfilesService.findAll();
    }

    // add mapping for GET "/degreeUserProfiles/{degreeUserProfileId}"
    @GetMapping("/degreeUserProfiles/{degreeUserProfileId}")
    public DegreeUserProfiles getDegreeUserProfile(@PathVariable int degreeUserProfileId){
        DegreeUserProfiles theDegreeUserProfile = degreeUserProfilesService.findById(degreeUserProfileId);
        if(theDegreeUserProfile == null){
            throw new RuntimeException("Degree User Profile id is not found " + degreeUserProfileId);
        }
        return theDegreeUserProfile;
    }


    // add mapping for POST "/degreeUserProfiles" to add new degree user profile
    @PostMapping("/degreeUserProfiles")
    public DegreeUserProfiles addDegreeUserProfile(@RequestBody DegreeUserProfiles theDegreeUserProfiles){
        theDegreeUserProfiles.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theDegreeUserProfiles.setCreated(localDateTime);
        theDegreeUserProfiles.setModified(null);
        DegreeUserProfiles newDegreeUserProfile = degreeUserProfilesService.save(theDegreeUserProfiles);
        return newDegreeUserProfile;
    }

    // add mapping for PUT "/degreeUserProfiles" to add new degree user profile
    @PutMapping("/degreeUserProfiles")
    public DegreeUserProfiles updateDegreeUserProfile(@RequestBody DegreeUserProfiles theDegreeUserProfiles){
        LocalDateTime localDateTime = LocalDateTime.now();
        theDegreeUserProfiles.setModified(localDateTime);
        DegreeUserProfiles newDegreeUserProfile = degreeUserProfilesService.save(theDegreeUserProfiles);
        return newDegreeUserProfile;
    }

    // add mapping for DELETE "/degreeUserProfiles/{degreeUserProfileId}" to delete degree user profile
    @DeleteMapping("/degreeUserProfiles/{degreeUserProfileId}")
    public String deleteDegreeUserProfile(@PathVariable int degreeUserProfileId){
        DegreeUserProfiles theDegreeUserProfile = degreeUserProfilesService.findById(degreeUserProfileId);
        degreeUserProfilesService.deleteById(degreeUserProfileId);
        if(theDegreeUserProfile == null){
            throw new RuntimeException("Degree User Profile id is not found " + degreeUserProfileId);
        }
        return "Deleted Degree User Profile id " + degreeUserProfileId;
    }
}
