package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Settings;
import com.appxbuild.matrimony.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SettingsRestController {

    private SettingsService settingsService;

    @Autowired
    public SettingsRestController(SettingsService theSettingsService){
        settingsService = theSettingsService;
    }

    // expose GET "/settings" to get a list of settings
    @GetMapping("/settings")
    public List<Settings> findAll(){
        return settingsService.findAll();
    }

    // add mapping for GET "/settings/{settingId}" to get a setting
    @GetMapping("/settings/{settingId}")
    public Settings findById(@PathVariable int settingId){
        Settings theSetting = settingsService.findById(settingId);
        if (theSetting == null){
            throw new RuntimeException("Setting id is not found " + settingId);
        }
        return theSetting;
    }

    // add mapping for POST "/settings" to add a new setting
    @PostMapping("/settings")
    public Settings addSetting(@RequestBody Settings theSettings){
        theSettings.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theSettings.setCreated(localDateTime);
        theSettings.setModified(null);
        Settings newSetting = settingsService.save(theSettings);
        return newSetting;
    }

    // add mapping for PUT "/settings" to update setting
    @PutMapping("/settings")
    public Settings updateSetting(@RequestBody Settings theSettings){
        LocalDateTime localDateTime = LocalDateTime.now();
        theSettings.setModified(localDateTime);
        Settings newSetting = settingsService.save(theSettings);
        return newSetting;
    }

    // add mapping for DELETE "/settings/{settingId}" to delete a setting
    @DeleteMapping("/settings/{settingId}")
    public String deleteById(@PathVariable int settingId){
        Settings theSetting = settingsService.findById(settingId);
        settingsService.deleteById(settingId);
        if (theSetting == null){
            throw new RuntimeException("Setting id is not found " + settingId);
        }
        return " Deleted Setting id " + settingId;
    }
}
