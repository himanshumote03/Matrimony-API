package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.DocumentsUserProfiles;
import com.appxbuild.matrimony.service.DocumentsUserProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DocumentsUserProfilesRestController {

    private DocumentsUserProfilesService documentsUserProfilesService;

    @Autowired
    public DocumentsUserProfilesRestController(DocumentsUserProfilesService theDocumentsUserProfilesService){
        documentsUserProfilesService = theDocumentsUserProfilesService;
    }

    // expose GET "/documentsUserProfiles" to get a list of Documents User Profiles
    @GetMapping("/documentsUserProfiles")
    public List<DocumentsUserProfiles> findAll(){
        return documentsUserProfilesService.findAll();
    }

    // add mapping for GET "/documentsUserProfiles/{documents_user_profileId}" to get Document User Profile
    @GetMapping("/documentsUserProfiles/{documents_user_profileId}")
    public DocumentsUserProfiles getDocumentUserProfile(@PathVariable int documents_user_profileId){
        DocumentsUserProfiles theDocumentsUserProfile = documentsUserProfilesService.findById(documents_user_profileId);
        if(theDocumentsUserProfile == null){
            throw  new RuntimeException("Document User Profile id is not found " + documents_user_profileId);
        }
        return theDocumentsUserProfile;
    }

    // add mapping for POST "/documentsUserProfiles" to add a new Document User Profile
    @PostMapping("/documentsUserProfiles")
    public DocumentsUserProfiles addDocumentUserProfile(@RequestBody DocumentsUserProfiles theDocumentsUserProfiles){
        theDocumentsUserProfiles.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theDocumentsUserProfiles.setCreated(localDateTime);
        theDocumentsUserProfiles.setModified(null);
        DocumentsUserProfiles newDocumentsUserProfile = documentsUserProfilesService.save(theDocumentsUserProfiles);
        return newDocumentsUserProfile;
    }

    // add mapping for PUT "/documentsUserProfiles" to update Document User Profile
    @PutMapping("/documentsUserProfiles")
    public DocumentsUserProfiles updateDocumentUserProfile(@RequestBody DocumentsUserProfiles theDocumentsUserProfiles){
        LocalDateTime localDateTime = LocalDateTime.now();
        theDocumentsUserProfiles.setModified(localDateTime);
        DocumentsUserProfiles newDocumentsUserProfile = documentsUserProfilesService.save(theDocumentsUserProfiles);
        return newDocumentsUserProfile;
    }

    // add mapping for DELETE "/documentsUserProfiles/{documents_user_profileId}" to delete Document User Profile
    @DeleteMapping("/documentsUserProfiles/{documentsUserProfileId}")
    public String deleteDocumentUserProfile(@PathVariable int documentsUserProfileId){
        DocumentsUserProfiles theDocumentsUserProfile = documentsUserProfilesService.findById(documentsUserProfileId);
        documentsUserProfilesService.deleteById(documentsUserProfileId);
        if (theDocumentsUserProfile == null){
            throw new RuntimeException("Document User Profile id id not found " + documentsUserProfileId);
        }
        return "Deleted Document User Profile Id " + documentsUserProfileId;
    }
}
