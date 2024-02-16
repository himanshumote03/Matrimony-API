package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Heights;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HeightsService {

    List<Heights> findAll();
    Heights findById(int theId);
    Heights save(Heights theHeights);
    void deleteById(int theId);

}
