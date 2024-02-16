package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Gotras;

import java.util.List;

public interface GotrasService {
    List<Gotras> findAll();
    Gotras findById(int theId);
    Gotras save(Gotras theGotras);
    void deleteById(int theId);
}
