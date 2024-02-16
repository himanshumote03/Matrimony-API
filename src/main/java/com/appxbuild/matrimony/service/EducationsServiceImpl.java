package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.EducationsDAO;
import com.appxbuild.matrimony.entity.Educations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationsServiceImpl implements EducationsService {

    private EducationsDAO educationsDAO;

    public EducationsServiceImpl(EducationsDAO educationsDAO) {
        this.educationsDAO = educationsDAO;
    }

    @Override
    public List<Educations> findAll() {
        return educationsDAO.findAll();
    }

    @Override
    public Educations findById(int theId) {
        Optional<Educations> result = educationsDAO.findById(theId);
        Educations theEducation = null;
        if(result.isPresent()){
            theEducation = result.get();
        }
        else {
            throw new RuntimeException("Education id id not found " + theId);
        }
        return theEducation;
    }

    @Override
    public Educations save(Educations theEducations) {
        return educationsDAO.save(theEducations);
    }

    @Override
    public void deleteById(int theId) {
        educationsDAO.deleteById(theId);
    }
}
