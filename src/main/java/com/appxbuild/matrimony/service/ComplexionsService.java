package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Complexions;

import java.util.List;

public interface ComplexionsService {
    List<Complexions> findAll();
    Complexions findById(int theId);
    Complexions save(Complexions theComplexions);
    void deleteById(int theId);}
