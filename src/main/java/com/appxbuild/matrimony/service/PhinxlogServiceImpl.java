package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.PhinxlogDAO;
import com.appxbuild.matrimony.entity.Phinxlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhinxlogServiceImpl implements PhinxlogService{

    private PhinxlogDAO phinxlogDAO;

    @Autowired
    public PhinxlogServiceImpl(PhinxlogDAO thePhinxlogDAO){
        phinxlogDAO = thePhinxlogDAO;
    }

    @Override
    public List<Phinxlog> findAll() {
        return phinxlogDAO.findAll();
    }


    @Override
    public Phinxlog save(Phinxlog thePhinxlog) {
        return phinxlogDAO.save(thePhinxlog);
    }

}
