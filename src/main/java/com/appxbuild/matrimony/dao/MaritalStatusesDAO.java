package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.MaritalStatuses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaritalStatusesDAO extends JpaRepository<MaritalStatuses, Integer> {
}
