package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.Photos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotosDAO extends JpaRepository<Photos,Integer> {

}
