package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Occupations;
import com.appxbuild.matrimony.service.OccupationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OccupationsRestController {

    private OccupationsService occupationsService;

    public OccupationsRestController(OccupationsService occupationsService) {
        this.occupationsService = occupationsService;
    }

    @GetMapping("/occupations")
    public List<Occupations> getOccupations() {
        return occupationsService.findAll();
    }
}
