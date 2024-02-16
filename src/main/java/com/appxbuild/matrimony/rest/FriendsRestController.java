package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Friends;
import com.appxbuild.matrimony.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class FriendsRestController {

    private FriendsService friendsService;

    @Autowired
    public FriendsRestController(FriendsService theFriendsService){
        friendsService = theFriendsService;
    }

    // expose "/friends" and return a list of Friends
    @GetMapping("/friends")
    public List<Friends> findAll() {
        return friendsService.findAll();
    }

    // add mapping for Get "/friends/{friendId}"
    @GetMapping("/friends/{friendId}")
    public Friends getFriend(@PathVariable int friendId){
        Friends theFriend = friendsService.findById(friendId);

        if(theFriend == null){
            throw new RuntimeException("Friend id is not found" + friendId);
        }
        return theFriend;
    }

    // add mapping for POST "/friends" - add new Friend
    @PostMapping("/friends")
    public Friends addFriend(@RequestBody Friends theFriends){
        theFriends.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theFriends.setCreated(localDateTime);
        theFriends.setModified(null);
        Friends newFriend = friendsService.save(theFriends);
        return newFriend;
    }

    // add mapping for PUT "/friends" - update existing Friend
    @PutMapping("/friends")
    public Friends updateFriend(@RequestBody Friends theFriends){
        LocalDateTime localDateTime = LocalDateTime.now();
        theFriends.setModified(localDateTime);
        Friends newFriend = friendsService.save(theFriends);
        return newFriend;
    }

    // add mapping for DELETE "/friends/{friendId}" - delete Friend
    @DeleteMapping("/friends/{friendId}")
    public String deleteFriend(@PathVariable int friendId){
        Friends theFriend = friendsService.findById(friendId);
        friendsService.deleteById(friendId);

        // throw exception if null
        if (theFriend == null){
            throw new RuntimeException("Friend id is not found - " + friendId);
        }
        return "Deleted Friend id - " + friendId;
    }

}

