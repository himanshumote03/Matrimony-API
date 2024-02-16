package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Drinks;

import java.util.List;

public interface DrinksService {
    List<Drinks> findAll();
    Drinks findById(int theId);
    Drinks save(Drinks theDrinks);
    void deleteById(int theId);
}
