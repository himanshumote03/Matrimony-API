package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Educations;
import com.appxbuild.matrimony.service.EducationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EducationsRestController {
    private EducationsService educationsService;

    public EducationsRestController(EducationsService educationsService) {
        this.educationsService = educationsService;
    }

    @GetMapping("/educations")
    public List<Educations> getEducation() {
        return educationsService.findAll();
    }
}
