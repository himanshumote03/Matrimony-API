package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.Genders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GendersDAO extends JpaRepository<Genders, Integer> {
}
