package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.AgenciesUsers;
import com.appxbuild.matrimony.service.AgenciesUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AgenciesUsersRestController {

    private AgenciesUsersService agenciesUsersService;

    @Autowired
    public AgenciesUsersRestController(AgenciesUsersService theAgenciesUsersService){
        agenciesUsersService = theAgenciesUsersService;
    }

    // expose GET "/agenciesUsers" to get a list of agencyUsers
    @GetMapping("/agenciesUsers")
    public List<AgenciesUsers> findAll(){
        return agenciesUsersService.findAll();
    }

    // add mapping for GET "/agenciesUsers/{agencyUserId}" to get an agency user
    @GetMapping("/agenciesUsers/{agencyUserId}")
    public AgenciesUsers findById(@PathVariable int agencyUserId){
        AgenciesUsers theAgenciesUsers = agenciesUsersService.findById(agencyUserId);
        if(theAgenciesUsers == null){
            throw  new RuntimeException("Agency User id is not found " + agencyUserId);
        }
        return theAgenciesUsers;
    }

    // add mapping for POST "/agenciesUsers" to add a new agency user
    @PostMapping("/agenciesUsers")
    private AgenciesUsers addAgencyUser(@RequestBody AgenciesUsers theAgenciesUsers){
         theAgenciesUsers.setId(0);
         long millis = System.currentTimeMillis();
         Timestamp timestamp = new Timestamp(millis);
         theAgenciesUsers.setCreated(timestamp);
         theAgenciesUsers.setModified(null);
         AgenciesUsers newAgenciesUser = agenciesUsersService.save(theAgenciesUsers);
         return newAgenciesUser;
    }

    // add mapping for PUT "/agenciesUsers" to update agency user
    @PutMapping("/agenciesUsers")
    private AgenciesUsers updateAgencyUser(@RequestBody AgenciesUsers theAgenciesUsers){
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        theAgenciesUsers.setModified(timestamp);
        AgenciesUsers newaAgenciesUsers = agenciesUsersService.save(theAgenciesUsers);
        return newaAgenciesUsers;
    }

    // add mapping for DELETE "/agenciesUsers/{agencyUserId}" to delete agency user
    @DeleteMapping("/agenciesUsers/{agencyUserId}")
    private String deleteById(@PathVariable int agencyUserId){
        AgenciesUsers theAgenciesUsers = agenciesUsersService.findById(agencyUserId);
        agenciesUsersService.deleteById(agencyUserId);
        if (theAgenciesUsers == null){
            throw new RuntimeException("Agency User id id not found " + agencyUserId);
        }
        return "Deleted Agency User Id " + agencyUserId;
    }
}
