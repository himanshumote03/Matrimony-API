package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.DocumentUserProfilesDAO;
import com.appxbuild.matrimony.entity.DocumentsUserProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentsUserProfilesServiceImpl implements DocumentsUserProfilesService {

    private DocumentUserProfilesDAO documentUserProfilesDAO;

    @Autowired
    public DocumentsUserProfilesServiceImpl(DocumentUserProfilesDAO theDocumentUserProfilesDAO){
        documentUserProfilesDAO = theDocumentUserProfilesDAO;
    }


    @Override
    public List<DocumentsUserProfiles> findAll() {
        return documentUserProfilesDAO.findAll();
    }

    @Override
    public DocumentsUserProfiles findById(int theId) {
        Optional<DocumentsUserProfiles> result = documentUserProfilesDAO.findById(theId);

        DocumentsUserProfiles theDocumentsUserProfile = null;
        if (result.isPresent()){
            theDocumentsUserProfile = result.get();
        }
        else {
            throw new RuntimeException("Did not find Document User Profile id - " + theId);
        }
        return theDocumentsUserProfile;
    }

    @Override
    public DocumentsUserProfiles save(DocumentsUserProfiles theDocumentsUserProfiles) {
        return documentUserProfilesDAO.save(theDocumentsUserProfiles);
    }


    @Override
    public void deleteById(int theId) {
        documentUserProfilesDAO.deleteById(theId);
    }
}
