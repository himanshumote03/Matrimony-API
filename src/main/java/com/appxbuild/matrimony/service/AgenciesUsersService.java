package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.AgenciesUsers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgenciesUsersService {

    List<AgenciesUsers> findAll();

    AgenciesUsers findById(int theId);

    AgenciesUsers save(AgenciesUsers theAgenciesUsers);

    void deleteById(int theId);

}
