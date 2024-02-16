package com.appxbuild.matrimony.rest;


import com.appxbuild.matrimony.entity.Thumbnails;
import com.appxbuild.matrimony.service.ThumbnailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ThumbnailsRestController {

    private ThumbnailsService thumbnailsService;

    @Autowired
    public ThumbnailsRestController(ThumbnailsService theThumbnailsService){
        thumbnailsService = theThumbnailsService;
    }

    // expose "/thumbnails" and return a list of Thumbnails
    @GetMapping("/thumbnails")
    public List<Thumbnails> findAll(){
        return thumbnailsService.findAll();
    }

    // add mapping for GET /thumbnails/{thumbnailId}
    @GetMapping("/thumbnails/{thumbnailId}")
    public Thumbnails getThumbnail(@PathVariable int thumbnailId){
        Thumbnails theThumbnail = thumbnailsService.findById(thumbnailId);
        if(theThumbnail == null){
            throw new RuntimeException("Thumbnail id is not found " + thumbnailId);
        }
        return theThumbnail;
    }

    // add mapping for POST /thumbnails - add Thumbnail
    @PostMapping("/thumbnails")
    public Thumbnails addThumbnail(@RequestBody Thumbnails theThumbnails){
        theThumbnails.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theThumbnails.setCreated(localDateTime);
        theThumbnails.setModified(localDateTime);
        Thumbnails newThumbnail = thumbnailsService.save(theThumbnails);
        return newThumbnail;
    }

    // add mapping for PUT /thumbnails - update existing Thumbnail
    @PutMapping("/thumbnails")
    public Thumbnails updateThumbnail(@RequestBody Thumbnails theThumbnails){
        LocalDateTime localDateTime = LocalDateTime.now();
        theThumbnails.setModified(localDateTime);
        Thumbnails newThumbnail = thumbnailsService.save(theThumbnails);
        return newThumbnail;
    }

    // add mapping for DELETE /thumbnails/{thumbnailId} - delete Thumbnail
    @DeleteMapping("/thumbnails/{thumbnailId}")
    public String deleteThumbnail(@PathVariable int thumbnailId){
        Thumbnails theThumbnail = thumbnailsService.findById(thumbnailId);
        thumbnailsService.deleteById(thumbnailId);

        // throw exception if null
        if (theThumbnail == null){
            throw new RuntimeException("Thumbnail id is not found - " + thumbnailId);
        }
        return "Deleted Thumbnail id - " + thumbnailId;
    }

 }
