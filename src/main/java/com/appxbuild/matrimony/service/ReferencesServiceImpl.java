package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.ReferencesDAO;
import com.appxbuild.matrimony.entity.References;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferencesServiceImpl implements ReferencesService {

    private ReferencesDAO referencesDAO;

    public ReferencesServiceImpl(ReferencesDAO referencesDAO) {
        this.referencesDAO = referencesDAO;
    }

    @Override
    public List<References> findAll() {
        return referencesDAO.findAll();
    }
}
