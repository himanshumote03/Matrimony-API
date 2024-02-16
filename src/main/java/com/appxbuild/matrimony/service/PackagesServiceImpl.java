package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.PackagesDAO;
import com.appxbuild.matrimony.entity.Packages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackagesServiceImpl implements PackagesService{

    private PackagesDAO packagesDAO;

    @Autowired
    public PackagesServiceImpl(PackagesDAO thePackagesDAO){
        packagesDAO = thePackagesDAO;
    }

    @Override
    public List<Packages> findAll() {
        return packagesDAO.findAll();
    }

    @Override
    public Packages findById(int theId) {
        Optional<Packages> result = packagesDAO.findById(theId);
        Packages thePackage = null;
        if(result.isPresent()){
            thePackage = result.get();
        }
        else {
            throw  new RuntimeException("Pack id is not found " + theId);
        }
        return thePackage;
    }

    @Override
    public Packages save(Packages thePackages) {
        return packagesDAO.save(thePackages);
    }

    @Override
    public void deleteById(int theId) {
        packagesDAO.deleteById(theId);
    }
}
