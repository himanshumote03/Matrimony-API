package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.MaritalStatuses;
import com.appxbuild.matrimony.service.MaritalStatusesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MaritalStatusesRestController {

    private MaritalStatusesService maritalStatusesService;

    public MaritalStatusesRestController(MaritalStatusesService maritalStatusesService) {
        this.maritalStatusesService = maritalStatusesService;
    }

    // "/maritalStatuses" -> get list of MaritalStatuses
    @GetMapping("/maritalStatuses")
    public List<MaritalStatuses> getMaritalStatuses() {
        return maritalStatusesService.findAll();
    }
}
