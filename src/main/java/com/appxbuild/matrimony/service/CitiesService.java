package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Cities;

import java.util.List;

public interface CitiesService {
    List<Cities> findAll();

    Cities findById(int theId);

    Cities save(Cities cities);

    void delete(int theId);
}
