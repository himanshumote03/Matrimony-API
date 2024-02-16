package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.DegreeUserProfiles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DegreeUserProfilesService {

    List<DegreeUserProfiles> findAll();

    DegreeUserProfiles findById(int theId);

    DegreeUserProfiles save(DegreeUserProfiles theDegreeUserProfiles);

    void deleteById(int theId);

}
