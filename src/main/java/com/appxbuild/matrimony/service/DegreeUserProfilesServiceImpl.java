package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.DegreeUserProfilesDAO;
import com.appxbuild.matrimony.entity.DegreeUserProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DegreeUserProfilesServiceImpl implements DegreeUserProfilesService {

    private DegreeUserProfilesDAO degreeUserProfilesDAO;

    @Autowired
    public DegreeUserProfilesServiceImpl(DegreeUserProfilesDAO theDegreeUserProfilesDAO){
        degreeUserProfilesDAO = theDegreeUserProfilesDAO;
    }

    @Override
    public List<DegreeUserProfiles> findAll() {
        return degreeUserProfilesDAO.findAll();
    }

    @Override
    public DegreeUserProfiles findById(int theId) {
        Optional<DegreeUserProfiles> result = degreeUserProfilesDAO.findById(theId);
        DegreeUserProfiles theDegreeUserProfile = null;
        if (result.isPresent()){
            theDegreeUserProfile = result.get();
        }
        else {
            throw new RuntimeException("Did not find Degree User Profile id - " + theId);
        }
        return theDegreeUserProfile;
    }

    @Override
    public DegreeUserProfiles save(DegreeUserProfiles theDegreeUserProfiles) {
        return degreeUserProfilesDAO.save(theDegreeUserProfiles);
    }

    @Override
    public void deleteById(int theId) {
        degreeUserProfilesDAO.deleteById(theId);
    }
}
