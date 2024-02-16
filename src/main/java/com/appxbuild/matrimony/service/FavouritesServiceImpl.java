package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.FavouritesDAO;
import com.appxbuild.matrimony.entity.Favourites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouritesServiceImpl implements FavouritesService{

    private FavouritesDAO favouritesDAO;

    @Autowired
    public FavouritesServiceImpl(FavouritesDAO theFavouritesDAO){
        favouritesDAO = theFavouritesDAO;
    }

    @Override
    public List<Favourites> findAll() {
        return favouritesDAO.findAll();
    }

    @Override
    public Favourites findById(int theId) {
        Optional<Favourites> result = favouritesDAO.findById(theId);
        Favourites theFavourite = null;
        if(result.isPresent()){
            theFavourite = result.get();
        }
        else {
            throw new RuntimeException("Favourite id is not found " + theId);
        }
        return theFavourite;
    }

    @Override
    public Favourites save(Favourites theFavourites) {
        return favouritesDAO.save(theFavourites);
    }

    @Override
    public void deleteById(int theId) {
        favouritesDAO.deleteById(theId);
    }
}
