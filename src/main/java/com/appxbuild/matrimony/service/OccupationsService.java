package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Occupations;

import java.util.List;

public interface OccupationsService {
    List<Occupations> findAll();
    Occupations findById(int theId);
    Occupations save(Occupations theOccupations);
    void deleteById(int theId);

}
