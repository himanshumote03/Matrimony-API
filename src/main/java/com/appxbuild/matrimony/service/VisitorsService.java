package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Visitors;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VisitorsService {

    List<Visitors> findAll();
    Visitors findById(int theId);
    Visitors save(Visitors theVisitors);
    void deleteById(int theId);
}
