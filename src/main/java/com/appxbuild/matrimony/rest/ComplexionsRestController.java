package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Complexions;
import com.appxbuild.matrimony.service.ComplexionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ComplexionsRestController {

    private ComplexionsService complexionsService;

    public ComplexionsRestController(ComplexionsService complexionsService) {
        this.complexionsService = complexionsService;
    }

    @GetMapping("/complexions")
    public List<Complexions> getComplexion() {
        return complexionsService.findAll();
    }
}
