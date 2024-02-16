package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.AgencyStatuses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyStatusesDAO extends JpaRepository<AgencyStatuses, Integer> {
}
