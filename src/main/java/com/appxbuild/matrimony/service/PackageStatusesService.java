package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.PackageStatuses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PackageStatusesService {

    List<PackageStatuses> findAll();
    PackageStatuses findById(int theId);
    PackageStatuses save(PackageStatuses thePackageStatuses);
    void deleteById(int theId);

}
