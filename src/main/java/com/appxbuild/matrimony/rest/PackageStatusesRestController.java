package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.PackageStatuses;
import com.appxbuild.matrimony.service.PackageStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PackageStatusesRestController {

    private PackageStatusesService packageStatusesService;

    @Autowired
    public PackageStatusesRestController(PackageStatusesService thePackageStatusesService){
        packageStatusesService = thePackageStatusesService;
    }

    // expose "/packageStatuses" and return a list of types
    @GetMapping("/packageStatuses")
    public List<PackageStatuses> findAll(){
        return packageStatusesService.findAll();
    }

    // add mapping for GET /packageStatuses/{packageStatusId} to get a package status
    @GetMapping("/packageStatuses/{packageStatusId}")
    public PackageStatuses getPackageStatus(@PathVariable int packageStatusId){
        PackageStatuses  thePackageStatus= packageStatusesService.findById(packageStatusId);
        if(thePackageStatus == null){
            throw new RuntimeException("package status id is not found " + packageStatusId);
        }
        return thePackageStatus;
    }

    // add mapping for POST /packageStatuses - add package status
    @PostMapping("/packageStatuses")
    public PackageStatuses addPackageStatus(@RequestBody PackageStatuses thepackageStatuses){
        thepackageStatuses.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        thepackageStatuses.setCreated(localDateTime);
        thepackageStatuses.setModified(null);
        PackageStatuses newPackageStatus = packageStatusesService.save(thepackageStatuses);
        return newPackageStatus;
    }

    // add mapping for PUT /packageStatuses - update existing packageStatus
    @PutMapping("/packageStatuses")
    public PackageStatuses updatePackageStatus(@RequestBody PackageStatuses thepackageStatuses){
        LocalDateTime localDateTime = LocalDateTime.now();
        thepackageStatuses.setModified(localDateTime);
        PackageStatuses newPackageStatus = packageStatusesService.save(thepackageStatuses);
        return newPackageStatus;
    }

    // add mapping for DELETE /packageStatuses/{relativeId} - delete packageStatus
    @DeleteMapping("/packageStatuses/{packageStatusId}")
    public String deletePackageStatus(@PathVariable int packageStatusId){
        PackageStatuses theType = packageStatusesService.findById(packageStatusId);
        packageStatusesService.deleteById(packageStatusId);

        // throw exception if null
        if (theType == null){
            throw new RuntimeException("Package Status id is not found - " + packageStatusId);
        }
        return "Deleted Package Status id - " + packageStatusId;
    }

 }
