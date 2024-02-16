package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.GotrasDAO;
import com.appxbuild.matrimony.entity.Gotras;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GotrasServiceImpl implements GotrasService {

    private GotrasDAO gotrasDAO;

    public GotrasServiceImpl(GotrasDAO gotrasDAO) {
        this.gotrasDAO = gotrasDAO;
    }

    @Override
    public List<Gotras> findAll() {
        return gotrasDAO.findAll();
    }

    @Override
    public Gotras findById(int theId) {
        Optional<Gotras> result = gotrasDAO.findById(theId);
        Gotras theGotras = null;
        if (result.isPresent()){
            theGotras = result.get();
        }
        else {
            throw new RuntimeException("Did not find Gotras id - " + theId);
        }
        return theGotras;
    }

    @Override
    public Gotras save(Gotras theGotras) {
        return gotrasDAO.save(theGotras);
    }

    @Override
    public void deleteById(int theId) {
        gotrasDAO.deleteById(theId);
    }
}
