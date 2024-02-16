package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.DocumentsUserProfiles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentsUserProfilesService {

    List<DocumentsUserProfiles> findAll();

    DocumentsUserProfiles findById(int theId);

    DocumentsUserProfiles save(DocumentsUserProfiles theDocumentsUserProfiles);

    void deleteById(int theId);

}
