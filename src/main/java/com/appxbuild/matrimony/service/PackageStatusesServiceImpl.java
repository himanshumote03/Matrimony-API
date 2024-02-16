package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.PackageStatusesDAO;
import com.appxbuild.matrimony.entity.PackageStatuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageStatusesServiceImpl implements PackageStatusesService{
    private PackageStatusesDAO packageStatusesDAO;
    @Autowired
    public PackageStatusesServiceImpl(PackageStatusesDAO thePackageStatusesDAO){
        packageStatusesDAO = thePackageStatusesDAO;
    }

    @Override
    public List<PackageStatuses> findAll() {
        return packageStatusesDAO.findAll();
    }

    @Override
    public PackageStatuses findById(int theId) {
        Optional<PackageStatuses> result = packageStatusesDAO.findById(theId);
        PackageStatuses thePackageStatuses = null;
        if(result.isPresent()){
            thePackageStatuses = result.get();
        }
        else {
            throw new RuntimeException("Did not find package status id - " + theId);
        }
        return thePackageStatuses;
    }

    @Override
    public PackageStatuses save(PackageStatuses thePackageStatuses) {
        return packageStatusesDAO.save(thePackageStatuses);
    }

    @Override
    public void deleteById(int theId) {
        packageStatusesDAO.deleteById(theId);
    }
}
