package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.TypesDAO;
import com.appxbuild.matrimony.entity.Types;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypesServiceImpl implements TypesService {

    private TypesDAO typesDAO;

    public TypesServiceImpl(TypesDAO typesDAO) {
        this.typesDAO = typesDAO;
    }

    @Override
    public List<Types> findAll() {
        return typesDAO.findAll();
    }

    @Override
    public Types findById(int theId) {
        Optional<Types> result = typesDAO.findById(theId);
        Types theType = null;
        if(result.isPresent()){
            theType = result.get();
        }
        else {
            throw new RuntimeException("Did not find type id - " + theId);
        }
        return theType;
    }

    @Override
    public Types save(Types theTypes) {
        return typesDAO.save(theTypes);
    }

    @Override
    public void deleteById(int theId) {
        typesDAO.deleteById(theId);
    }
}
