package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouritesDAO extends JpaRepository<Favourites,Integer> {

}
