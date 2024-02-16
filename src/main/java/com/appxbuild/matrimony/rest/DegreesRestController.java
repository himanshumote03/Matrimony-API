package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Degrees;
import com.appxbuild.matrimony.service.DegreesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DegreesRestController {

    private DegreesService degreesService;

    @Autowired
    public DegreesRestController(DegreesService theDegreesService){
        degreesService = theDegreesService;
    }

    // expose GET "/degrees" to get a list of degrees
    @GetMapping("/degrees")
    public List<Degrees> findALl(){
        return degreesService.findAll();
    }
}
