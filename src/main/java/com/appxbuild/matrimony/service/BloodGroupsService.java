package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.BloodGroups;

import java.util.List;

public interface BloodGroupsService {
    List<BloodGroups> findAll();

    BloodGroups findById(int theId);

    BloodGroups save(BloodGroups theBloodGroups);

    void deleteById(int theId);
}
