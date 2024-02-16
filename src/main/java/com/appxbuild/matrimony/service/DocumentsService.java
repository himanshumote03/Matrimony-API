package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Documents;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentsService {

    List<Documents> findAll();

    Documents findById(int theId);

    Documents save(Documents theDocuments);

    void deleteById(int theId);
}
