package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Packages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PackagesService {

     List<Packages> findAll();
     Packages findById(int theId);
     Packages  save(Packages thePackages);
     void deleteById(int theId);

}
