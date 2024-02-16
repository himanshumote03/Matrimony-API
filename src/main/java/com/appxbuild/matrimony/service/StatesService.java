package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.States;

import java.util.List;

public interface StatesService {

    List<States> findAll();

    States findById(int theId);

    States save(States states);

    void delete(int theId);
}
