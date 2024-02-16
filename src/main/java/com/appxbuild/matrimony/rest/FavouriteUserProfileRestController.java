package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.FavouriteUserProfile;
import com.appxbuild.matrimony.service.FavouriteUserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class FavouriteUserProfileRestController {

    private FavouriteUserProfilesService favouriteUserProfilesService;

    @Autowired
    public FavouriteUserProfileRestController(FavouriteUserProfilesService theFavouriteUserProfilesService){
        favouriteUserProfilesService = theFavouriteUserProfilesService;
    }

    // expose "/favouritesUserProfiles" and return a list of favourite User Profiles
    @GetMapping("/favouritesUserProfiles")
    public List<FavouriteUserProfile> findAll() {
        return favouriteUserProfilesService.findAll();
    }

    // add mapping for Get "/favouritesUserProfiles/{favouritesUserProfilesId}"
    @GetMapping("/favouritesUserProfiles/{favouritesUserProfilesId}")
    public FavouriteUserProfile getFavouriteUserProfile(@PathVariable int favouritesUserProfilesId){
        FavouriteUserProfile theFavouriteUserProfile = favouriteUserProfilesService.findById(favouritesUserProfilesId);

        if(theFavouriteUserProfile == null){
            throw new RuntimeException("Favourite is not found" + favouritesUserProfilesId);
        }
        return theFavouriteUserProfile;
    }

    // add mapping for POST "/favouritesUserProfiles" - add new favourite User Profile
    @PostMapping("/favouritesUserProfiles")
    public FavouriteUserProfile addFavouriteUserProfile(@RequestBody FavouriteUserProfile theFavouriteUserProfile){
        theFavouriteUserProfile.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theFavouriteUserProfile.setCreated(localDateTime);
        theFavouriteUserProfile.setModified(null);
        FavouriteUserProfile newFavouriteUserProfile = favouriteUserProfilesService.save(theFavouriteUserProfile);
        return newFavouriteUserProfile;
    }

    // add mapping for PUT "/favouritesUserProfiles" - update existing favourite User Profile
    @PutMapping("/favouritesUserProfiles")
    public FavouriteUserProfile updateFavouriteUserProfile(@RequestBody FavouriteUserProfile theFavouriteUserProfile){
        LocalDateTime localDateTime = LocalDateTime.now();
        theFavouriteUserProfile.setModified(localDateTime);
        FavouriteUserProfile newFavouriteUserProfile = favouriteUserProfilesService.save(theFavouriteUserProfile);
        return newFavouriteUserProfile;
    }

    // add mapping for DELETE "/favouritesUserProfiles/{favouritesUserProfilesId}" - delete favourite User Profile
    @DeleteMapping("/favouritesUserProfiles/{favouritesUserProfilesId}")
    public String deleteFavouriteUserProfile(@PathVariable int favouritesUserProfilesId){
        FavouriteUserProfile theFavouriteUserProfile = favouriteUserProfilesService.findById(favouritesUserProfilesId);
        favouriteUserProfilesService.deleteById(favouritesUserProfilesId);

        // throw exception if null
        if (theFavouriteUserProfile == null){
            throw new RuntimeException("Favourite User Profile id is not found - " + favouritesUserProfilesId);
        }
        return "Deleted Favourite User Profile id - " + favouritesUserProfilesId;
    }

}

