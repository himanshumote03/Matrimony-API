package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Favourites;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavouritesService {

    List<Favourites> findAll();
    Favourites findById(int theId);
    Favourites save(Favourites theFavourites);
    void deleteById(int theId);
}
