package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.VisitorsDAO;
import com.appxbuild.matrimony.entity.Visitors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorsServiceImpl implements VisitorsService{

    private VisitorsDAO visitorsDAO;

    @Autowired
    public VisitorsServiceImpl(VisitorsDAO theVisitorsDAO){
        visitorsDAO = theVisitorsDAO;
    }

    @Override
    public List<Visitors> findAll() {
        return visitorsDAO.findAll();
    }

    @Override
    public Visitors findById(int theId) {
        Optional<Visitors> result = visitorsDAO.findById(theId);
        Visitors theVisitor = null;
        if(result.isPresent()){
            theVisitor = result.get();
        }
        else {
            throw new RuntimeException("Visitor id is not found " + theId);
        }
        return theVisitor;
    }

    @Override
    public Visitors save(Visitors theVisitors) {
        return visitorsDAO.save(theVisitors);
    }

    @Override
    public void deleteById(int theId) {

        visitorsDAO.deleteById(theId);
    }
}
