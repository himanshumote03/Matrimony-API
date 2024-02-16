package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Countries;

import java.util.List;

public interface CountriesService {

    List<Countries> findAll();

    Countries findById(int theId);

    Countries save(Countries countries);

    void delete(int theId);
}
