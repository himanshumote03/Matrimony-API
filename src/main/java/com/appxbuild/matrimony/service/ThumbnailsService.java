package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Thumbnails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThumbnailsService {

    List<Thumbnails> findAll();
    Thumbnails findById(int theId);
    Thumbnails save(Thumbnails theThumbnails);
    void deleteById(int theId);

}
