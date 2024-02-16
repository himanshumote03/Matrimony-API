package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.PackageStatuses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageStatusesDAO extends JpaRepository<PackageStatuses, Integer> {
}
