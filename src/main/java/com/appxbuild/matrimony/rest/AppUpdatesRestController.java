package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.AppUpdates;
import com.appxbuild.matrimony.service.AppUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppUpdatesRestController {

    private AppUpdateService appUpdateService;

    @Autowired
    public AppUpdatesRestController(AppUpdateService theAppUpdateService){
        appUpdateService = theAppUpdateService;
    }

    // expose GET "/appUpdates" to get a list of app updates
    @GetMapping("/appUpdates")
    public List<AppUpdates> findALl(){
       return appUpdateService.findALl();
    }

    // add mapping for GET "/appUpdates/{appUpdateId}" to get a app update
    @GetMapping("/appUpdates/{appUpdateId}")
    public AppUpdates findById(@PathVariable int appUpdateId){
        AppUpdates theAppUpdate = appUpdateService.findByAll(appUpdateId);
        if(theAppUpdate == null){
            throw new RuntimeException("App Update id is not found " + appUpdateId);
        }
        return theAppUpdate;
    }

    // add mapping for POST "/appUpdates" to add a new app update
    @PostMapping("/appUpdates")
    public AppUpdates addAppUpdate(@RequestBody AppUpdates theAppUpdates){
        theAppUpdates.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theAppUpdates.setCreated(localDateTime);
        theAppUpdates.setModified(null);
        AppUpdates newAppUpdate = appUpdateService.save(theAppUpdates);
        return newAppUpdate;
    }

    // add mapping for PUT "/appUpdates" to update an app update
    @PutMapping("/appUpdates")
    public AppUpdates updateAppUpdate(@RequestBody AppUpdates theAppUpdates){
        LocalDateTime localDateTime = LocalDateTime.now();
        theAppUpdates.setModified(localDateTime);
        AppUpdates newAppUpdate = appUpdateService.save(theAppUpdates);
        return newAppUpdate;
    }

    // add mapping for DELETE "/appUpdates/{appUpdateId}" to delete an app update
    @DeleteMapping("/appUpdates/{appUpdateId}")
    public String deleteById(@PathVariable int appUpdateId){
        AppUpdates theAppUpdate = appUpdateService.findByAll(appUpdateId);
        appUpdateService.deleteById(appUpdateId);
        if(theAppUpdate == null){
            throw new RuntimeException("App Update id is not found " + appUpdateId);
        }
        return "Deleted App Update Id " + appUpdateId;
    }

}
