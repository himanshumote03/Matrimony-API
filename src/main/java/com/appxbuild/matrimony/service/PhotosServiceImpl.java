package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.PhotosDAO;
import com.appxbuild.matrimony.entity.Photos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotosServiceImpl implements PhotosService{

    private PhotosDAO photosDAO;

    @Autowired
    public PhotosServiceImpl(PhotosDAO thePhotosDAO){
        photosDAO = thePhotosDAO;
    }

    @Override
    public List<Photos> findAll() {
        return photosDAO.findAll();
    }

    @Override
    public Photos findById(int theId) {
        Optional<Photos> result = photosDAO.findById(theId);
        Photos thePhoto = null;
        if(result.isPresent()){
            thePhoto = result.get();
        }
        else {
            throw  new RuntimeException("Photo id is not found " + theId);
        }
        return thePhoto;
    }

    @Override
    public Photos save(Photos thePhotos) {
        return photosDAO.save(thePhotos);
    }

    @Override
    public void deleteById(int theId) {
        photosDAO.deleteById(theId);
    }
}
