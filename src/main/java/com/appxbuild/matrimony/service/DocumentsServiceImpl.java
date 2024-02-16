package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.DocumentsDAO;
import com.appxbuild.matrimony.entity.Documents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentsServiceImpl implements DocumentsService {

    private DocumentsDAO documentsDAO;

    @Autowired
    public DocumentsServiceImpl(DocumentsDAO theDocumentsDAO){
        documentsDAO = theDocumentsDAO;
    }


    @Override
    public List<Documents> findAll() {
        return documentsDAO.findAll();
    }

    @Override
    public Documents findById(int theId) {
        Optional<Documents> result = documentsDAO.findById(theId);

        Documents theDocument = null;
        if (result.isPresent()){
            theDocument = result.get();
        }
        else {
            throw new RuntimeException("Did not find device id - " + theId);
        }
        return theDocument;
    }

    @Override
    public Documents save(Documents theDocuments) {
        return documentsDAO.save(theDocuments);
    }


    @Override
    public void deleteById(int theId) {
        documentsDAO.deleteById(theId);
    }
}
