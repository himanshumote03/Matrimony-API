package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.References;
import com.appxbuild.matrimony.service.ReferencesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReferencesRestController {

    private ReferencesService referencesService;

    public ReferencesRestController(ReferencesService referencesService) {
        this.referencesService = referencesService;
    }

    @GetMapping("/references")
    public List<References> getAll() {
        return referencesService.findAll();
    }
}
