package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Educations;

import java.util.List;

public interface EducationsService {
    List<Educations> findAll();
    Educations findById(int theId);
    Educations save(Educations theEducations);
    void deleteById(int theId);
}
