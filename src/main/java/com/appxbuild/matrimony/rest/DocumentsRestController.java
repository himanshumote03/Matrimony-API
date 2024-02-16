package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Documents;
import com.appxbuild.matrimony.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DocumentsRestController {

    private DocumentsService documentsService;

    @Autowired
    public DocumentsRestController(DocumentsService theDocumentsService){
        documentsService = theDocumentsService;
    }

    // expose GET "/documents" to get a list of documents
    @GetMapping("/documents")
    public List<Documents> findAll(){
        return documentsService.findAll();
    }

    // add mapping for GET "/documents/{documentId}" to get an document
    @GetMapping("/documents/{documentId}")
    public Documents getDocument(@PathVariable int documentId){
        Documents theDocument = documentsService.findById(documentId);
        if(theDocument == null){
            throw  new RuntimeException("Document id is not found " + documentId);
        }
        return theDocument;
    }

    // add mapping for POST "/documents" to add a new document
    @PostMapping("/documents")
    public Documents addDocument(@RequestBody Documents theDocuments){
        theDocuments.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theDocuments.setCreated(localDateTime);
        theDocuments.setModified(null);
        Documents newDocument = documentsService.save(theDocuments);
        return newDocument;
    }

    // add mapping for PUT "/documents" to update document
    @PutMapping("/documents")
    public Documents updateDocument(@RequestBody Documents theDocuments){
        LocalDateTime localDateTime = LocalDateTime.now();
        theDocuments.setModified(localDateTime);
        Documents newDocument = documentsService.save(theDocuments);
        return newDocument;
    }

    // add mapping for DELETE "/documents/{documentId}" to delete document
    @DeleteMapping("/documents/{documentId}")
    public String deleteDocument(@PathVariable int documentId){
        Documents theDocument = documentsService.findById(documentId);
        documentsService.deleteById(documentId);
        if (theDocument == null){
            throw new RuntimeException("Document id id not found " + documentId);
        }
        return "Deleted Document Id " + documentId;
    }
}
