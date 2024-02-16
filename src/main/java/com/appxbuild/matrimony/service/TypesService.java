package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Types;

import java.util.List;

public interface TypesService {
    List<Types> findAll();
    Types findById(int theId);
    Types save(Types theTypes);
    void deleteById(int theId);
}
