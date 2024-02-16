package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Smokes;
import com.appxbuild.matrimony.service.SmokesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SmokesRestController {
    private SmokesService smokesService;

    public SmokesRestController(SmokesService smokesService) {
        this.smokesService = smokesService;
    }

    @GetMapping("/smokes")
    public List<Smokes> getAllSmokes() {
        return smokesService.findAll();
    }
}
