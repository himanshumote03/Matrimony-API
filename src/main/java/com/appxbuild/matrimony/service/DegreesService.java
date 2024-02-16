package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Degrees;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DegreesService {

    List<Degrees> findAll();

    Degrees findById(int theId);

    Degrees save(Degrees theDegrees);

    void deleteById(int theId);

}
