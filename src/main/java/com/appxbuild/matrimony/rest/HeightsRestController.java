package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Heights;
import com.appxbuild.matrimony.service.HeightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HeightsRestController {

    private HeightsService heightsService;

    @Autowired
    public HeightsRestController(HeightsService theHeightsService){
        heightsService = theHeightsService;
    }

    // expose "/heights" and return a list of heights
    @GetMapping("/heights")
    public List<Heights> findAll(){
        return heightsService.findAll();
    }

    // add mapping for Get "/heights/{agencyId}" to get a height
    @GetMapping("/heights/{heightId}")
    public Heights getHeight(@PathVariable int heightId){
        Heights theHeight = heightsService.findById(heightId);
        if(theHeight == null){
            throw new RuntimeException("Height is not found" + heightId);
        }
        return theHeight;
    }

    //add mapping for POST "/heights" - add new height
    @PostMapping("/heights")
    public Heights addHeight(@RequestBody Heights theHeights){
        theHeights.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theHeights.setCreated(localDateTime);
        theHeights.setModified(null);
        Heights newHeight = heightsService.save(theHeights);
        return newHeight;
    }

    // add mapping for PUT "/heights" - update existing height
    @PutMapping("/heights")
    public Heights updateHeight(@RequestBody Heights theHeights){
        LocalDateTime localDateTime = LocalDateTime.now();
        theHeights.setModified(localDateTime);
        Heights newHeight = heightsService.save(theHeights);
        return newHeight;
    }

    // add mapping for DELETE "/heights/{heightId}" - delete height
    @DeleteMapping("/heights/{heightId}")
    public String deleteHeight(@PathVariable int heightId){
        Heights theHeight = heightsService.findById(heightId);
        heightsService.deleteById(heightId);
        // throw exception if null
        if (theHeight == null){
            throw new RuntimeException("Height id is not found - " + heightId);
        }
        return "Deleted Height id - " + heightId;
    }
}
