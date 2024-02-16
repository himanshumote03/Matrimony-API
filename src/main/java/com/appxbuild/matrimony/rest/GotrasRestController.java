package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Gotras;
import com.appxbuild.matrimony.service.GotrasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GotrasRestController {

    private GotrasService gotrasService;

    public GotrasRestController(GotrasService gotrasService) {
        this.gotrasService = gotrasService;
    }

    // "/gotras" -> get list of all Gotras
    @GetMapping("/gotras")
    public List<Gotras> getAllGotras() {
        return gotrasService.findAll();
    }
}
