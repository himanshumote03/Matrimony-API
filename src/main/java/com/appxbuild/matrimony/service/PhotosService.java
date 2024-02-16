package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Photos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhotosService {

    List<Photos> findAll();
    Photos findById(int theId);
    Photos save(Photos thePhotos);
    void deleteById(int theId);

}
