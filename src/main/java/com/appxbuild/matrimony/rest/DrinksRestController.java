package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Drinks;
import com.appxbuild.matrimony.service.DrinksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DrinksRestController {
    private DrinksService drinksService;

    public DrinksRestController(DrinksService drinksService) {
        this.drinksService = drinksService;
    }

    @GetMapping("/drinks")
    public List<Drinks> getAllDrinks(){
        return drinksService.findAll();
    }
}
