package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.BloodGroupsDAO;
import com.appxbuild.matrimony.entity.BloodGroups;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodGroupsServiceImpl implements BloodGroupsService {

    public BloodGroupsServiceImpl(BloodGroupsDAO bloodGroupsDAO) {
        this.bloodGroupsDAO = bloodGroupsDAO;
    }

    private BloodGroupsDAO bloodGroupsDAO;

    @Override
    public List<BloodGroups> findAll() {
        return bloodGroupsDAO.findAll();
    }

    @Override
    public BloodGroups findById(int theId) {
        Optional<BloodGroups> result = bloodGroupsDAO.findById(theId);
        BloodGroups theBloodGroup = null;
        if (result.isPresent()){
            theBloodGroup = result.get();
        }
        else {
            throw new RuntimeException("Did not find blood group id - " + theId);
        }
        return theBloodGroup;
    }

    @Override
    public BloodGroups save(BloodGroups theBloodGroups) {
        return bloodGroupsDAO.save(theBloodGroups);
    }

    @Override
    public void deleteById(int theId) {
        bloodGroupsDAO.deleteById(theId);
    }
}
