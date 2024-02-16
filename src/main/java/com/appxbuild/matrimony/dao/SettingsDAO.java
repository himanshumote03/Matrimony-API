package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingsDAO extends JpaRepository<Settings,Integer> {

}
