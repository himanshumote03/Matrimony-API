package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.ThumbnailsDAO;
import com.appxbuild.matrimony.entity.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThumbnailsServiceImpl implements ThumbnailsService {

    private ThumbnailsDAO thumbnailsDAO;

    @Autowired
    public ThumbnailsServiceImpl(ThumbnailsDAO theThumbnailsDAO){
        thumbnailsDAO = theThumbnailsDAO;
    }


    @Override
    public List<Thumbnails> findAll() {
        return thumbnailsDAO.findAll();
    }

    @Override
    public Thumbnails findById(int theId) {
        Optional<Thumbnails> result = thumbnailsDAO.findById(theId);

        Thumbnails theThumbnail = null;
        if (result.isPresent()){
            theThumbnail = result.get();
        }
        else {
            throw new RuntimeException("Did not find agency id - " + theId);
        }
        return theThumbnail;
    }

    @Override
    public Thumbnails save(Thumbnails theThumbnails) {
        return thumbnailsDAO.save(theThumbnails);
    }


    @Override
    public void deleteById(int theId) {
        thumbnailsDAO.deleteById(theId);
    }
}
