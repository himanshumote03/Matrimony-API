package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Phinxlog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhinxlogService {

    List<Phinxlog> findAll();
    Phinxlog save(Phinxlog thePhinxlog);

}
