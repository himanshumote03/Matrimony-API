package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.Agencies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyDAO extends JpaRepository<Agencies, Integer> {
}
