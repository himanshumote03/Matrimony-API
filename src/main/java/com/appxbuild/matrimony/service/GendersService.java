package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Genders;

import java.util.List;

public interface GendersService {
    List<Genders> findAll();
    Genders findById(int theId);
    Genders save(Genders theGenders);
    void deleteById(int theId);
}
