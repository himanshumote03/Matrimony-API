package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Genders;
import com.appxbuild.matrimony.service.GendersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GendersRestController {

    private GendersService gendersService;

    public GendersRestController(GendersService gendersService) {
        this.gendersService = gendersService;
    }

    // "/genders" -> get a list of genders
    @GetMapping("/genders")
    public List<Genders> getGenders(){
        return gendersService.findAll();
    }


}
