package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Favourites;
import com.appxbuild.matrimony.service.FavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class FavouritesRestController {

    private FavouritesService favouritesService;

    @Autowired
    public FavouritesRestController(FavouritesService theFavouritesService){
        favouritesService = theFavouritesService;
    }

    // expose "/favourites" and return a list of Favourites
    @GetMapping("/favourites")
    public List<Favourites> findAll() {
        return favouritesService.findAll();
    }

    // add mapping for Get "/favourites/{favouriteId}"
    @GetMapping("/favourites/{favouriteId}")
    public Favourites getFavourite(@PathVariable int favouriteId){
        Favourites theFavourite = favouritesService.findById(favouriteId);

        if(theFavourite == null){
            throw new RuntimeException("Favourite is not found" + favouriteId);
        }
        return theFavourite;
    }

    // add mapping for POST "/favourites" - add new Favourite
    @PostMapping("/favourites")
    public Favourites addFavourite(@RequestBody Favourites theFavourites){
        theFavourites.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theFavourites.setCreated(localDateTime);
        theFavourites.setModified(null);
        Favourites newFavourite = favouritesService.save(theFavourites);
        return newFavourite;
    }

    // add mapping for PUT "/favourites" - update existing Favourite
    @PutMapping("/favourites")
    public Favourites updateFavourite(@RequestBody Favourites theFavourites){
        LocalDateTime localDateTime = LocalDateTime.now();
        theFavourites.setModified(localDateTime);
        Favourites newFavourite = favouritesService.save(theFavourites);
        return newFavourite;
    }

    // add mapping for DELETE "/favourites/{favouriteId}" - delete Favourite
    @DeleteMapping("/favourites/{favouriteId}")
    public String deleteFavourite(@PathVariable int favouriteId){
        Favourites theFavourite = favouritesService.findById(favouriteId);
        favouritesService.deleteById(favouriteId);

        // throw exception if null
        if (theFavourite == null){
            throw new RuntimeException("Favourite id is not found - " + favouriteId);
        }
        return "Deleted Favourite id - " + favouriteId;
    }

}

