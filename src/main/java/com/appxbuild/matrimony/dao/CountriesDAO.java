package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesDAO extends JpaRepository<Countries, Integer> {
}
