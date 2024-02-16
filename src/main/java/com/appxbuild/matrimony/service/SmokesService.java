package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Smokes;

import java.util.List;

public interface SmokesService {
    List<Smokes> findAll();
    Smokes findById(int theId);
    Smokes save(Smokes theSmokes);
    void deleteById(int theId);
}
