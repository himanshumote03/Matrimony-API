package com.appxbuild.matrimony.rest;


import com.appxbuild.matrimony.entity.Photos;
import com.appxbuild.matrimony.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhotosRestController {

    private PhotosService photosService;

    @Autowired
    public PhotosRestController(PhotosService thePhotosService){
        photosService = thePhotosService;
    }

    // expose "/photos" and return a list of Photos
    @GetMapping("/photos")
    public List<Photos> findAll(){
        return photosService.findAll();
    }

    // add mapping for GET /photos/{photoId}
    @GetMapping("/photos/{photoId}")
    public Photos getPhoto(@PathVariable int photoId){
        Photos thePhoto = photosService.findById(photoId);
        if(thePhoto == null){
            throw new RuntimeException("Photo id is not found " + photoId);
        }
        return thePhoto;
    }

    // add mapping for POST /photos - add Photo
    @PostMapping("/photos")
    public Photos addPhoto(@RequestBody Photos thePhotos){
        thePhotos.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        thePhotos.setCreated(localDateTime);
        thePhotos.setModified(localDateTime);
        Photos newPhoto = photosService.save(thePhotos);
        return newPhoto;
    }

    // add mapping for PUT /photos - update existing Photo
    @PutMapping("/photos")
    public Photos updatePhoto(@RequestBody Photos thePhotos){
        LocalDateTime localDateTime = LocalDateTime.now();
        thePhotos.setModified(localDateTime);
        Photos newPhoto = photosService.save(thePhotos);
        return newPhoto;
    }

    // add mapping for DELETE /photos/{photoId} - delete Photo
    @DeleteMapping("/photos/{photoId}")
    public String deletePhoto(@PathVariable int photoId){
        Photos thePhoto = photosService.findById(photoId);
        photosService.deleteById(photoId);

        // throw exception if null
        if (thePhoto == null){
            throw new RuntimeException("Photo id is not found - " + photoId);
        }
        return "Deleted Photo id - " + photoId;
    }

 }
