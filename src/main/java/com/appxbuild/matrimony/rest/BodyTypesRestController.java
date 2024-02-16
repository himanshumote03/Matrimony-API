package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.BodyTypes;
import com.appxbuild.matrimony.service.BodyTypesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BodyTypesRestController {

    private BodyTypesService bodyTypesService;

    public BodyTypesRestController(BodyTypesService bodyTypesService) {
        this.bodyTypesService = bodyTypesService;
    }

    // "/bodyTypes" -> get list of BodyTypes
    @GetMapping("/bodyTypes")
    public List<BodyTypes> getAllBodyTypes() {
        return bodyTypesService.findAll();
    }
}
