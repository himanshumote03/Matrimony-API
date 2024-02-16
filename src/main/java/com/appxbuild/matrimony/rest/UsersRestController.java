package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.UserStatuses;
import com.appxbuild.matrimony.entity.Users;
import com.appxbuild.matrimony.service.UserStatusesService;
import com.appxbuild.matrimony.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersRestController {
    private UsersService usersService;


    public UsersRestController(UsersService usersService) {
        this.usersService = usersService;
    }

    // "/users" -> return a list of users
    @GetMapping("/users")
    public List<Users> findAll() {
        System.out.println("\n\n------------------------> Error: "+usersService.findAll()+"\n\n");
        return usersService.findAll();
    }

    // "/users/{userId}" -> return user with of specific id
    @GetMapping("/users/{userId}")
    public Users getAgency(@PathVariable int userId) {
        Users users = usersService.findById(userId);

        if (users == null) {
            throw new RuntimeException("User id not found: " + userId);
        }
        System.out.println("\n\n------------------------> Error: "+users +"\n\n");
        return users;
    }

    // "/users" -> add new users
    @PostMapping("/users")
    public Users addUser(@RequestBody Users users) {

        users.setId(0);
        LocalDateTime dt = LocalDateTime.now();
        users.setCreated(dt);
        users.setModified(null);

        Users dbUsers = usersService.save(users);
        return dbUsers;
    }

    // "/users" -> update existing user
    @PutMapping("/users")
    public Users updateAgency(@RequestBody Users users) {

        System.out.println("------------updating------------");
        LocalDateTime dt = LocalDateTime.now();
        users.setModified(dt);
        System.out.println("\n\n----------------------->> " + usersService.save(users) + " <<--------------------\n\n");

        Users dbUsers = usersService.save(users);
        return dbUsers;
    }

    // "/users/{agencyId}" -> delete existing users
    @DeleteMapping("/users/{userId}")
    public String delete(@PathVariable int userId) {

        Users dbUser = usersService.findById(userId);

        if (dbUser == null) {
            throw new RuntimeException("Agency id not found: " + userId);
        }
//        dbUser.setAgencyStatuses(null);
        usersService.delete(userId);
        return ("Agency id: " + userId + " deleted");
    }
}
