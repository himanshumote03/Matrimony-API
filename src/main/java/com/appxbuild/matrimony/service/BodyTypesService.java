package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.BodyTypes;

import java.util.List;

public interface BodyTypesService {
    List<BodyTypes> findAll();
    BodyTypes findById(int theId);
    BodyTypes save(BodyTypes theBodyTypes);
    void deleteById(int theId);
}
