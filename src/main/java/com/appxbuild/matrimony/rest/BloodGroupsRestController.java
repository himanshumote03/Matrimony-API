package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.BloodGroups;
import com.appxbuild.matrimony.entity.Users;
import com.appxbuild.matrimony.service.BloodGroupsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BloodGroupsRestController {

    private BloodGroupsService bloodGroupsService;

    public BloodGroupsRestController(BloodGroupsService bloodGroupsService) {
        this.bloodGroupsService = bloodGroupsService;
    }

    // "/bloodGroups" -> return a list of users
    @GetMapping("/bloodGroups")
    public List<BloodGroups> findAll() {
        System.out.println("\n\n------------------------> Error: "+bloodGroupsService.findAll()+"\n\n");
        return bloodGroupsService.findAll();
    }
}
