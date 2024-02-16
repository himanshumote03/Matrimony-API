package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Packages;
import com.appxbuild.matrimony.service.PackagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PackagesRestController {

    private PackagesService packagesService;

    @Autowired
    public PackagesRestController(PackagesService thePackagesService){
        packagesService = thePackagesService;
    }

    // expose GET "/packages" to get a list of package
    @GetMapping("/packages")
    public List<Packages> findAll(){
       return packagesService.findAll();
    }

    // add mapping for GET "/packages/{packageId}" to get a package
    @GetMapping("/packages/{packageId}")
    public Packages findById(@PathVariable int packageId){
        Packages thePackage = packagesService.findById(packageId);
        if(thePackage == null){
            throw new RuntimeException("Package id is not found " + packageId);
        }
        return thePackage;
    }

    // add mapping for POST "/packages" to get a package to add a new package
    @PostMapping("/packages")
    public Packages addPackage(@RequestBody Packages thePackages){
        thePackages.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        thePackages.setCreated(localDateTime);
        thePackages.setModified(null);
        Packages newPackage = packagesService.save(thePackages);
        return newPackage;
    }

    // add mapping for POST "/packages" to get a package to add a new package
    @PutMapping("/packages")
    public Packages updatePackage(@RequestBody Packages thePackages){
        LocalDateTime localDateTime = LocalDateTime.now();
        thePackages.setModified(localDateTime);
        Packages newPackage = packagesService.save(thePackages);
        return newPackage;
    }

    // add mapping for DELETE "/packages/{packageId}" to delete a package
    @DeleteMapping("/packages/{packageId}")
    public String deleteById(@PathVariable int packageId){
        Packages thePackage = packagesService.findById(packageId);
        packagesService.deleteById(packageId);
        if(thePackage == null){
            throw new RuntimeException("Package id is not found " + packageId);
        }
        return "Deleted Package Id is " + packageId;
    }

}
