package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Phinxlog;
import com.appxbuild.matrimony.service.PhinxlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhinxlogRestController {

    private PhinxlogService phinxlogService;

    @Autowired
    public PhinxlogRestController(PhinxlogService thePhinxlogService){
        phinxlogService = thePhinxlogService;
    }

    // expose "/phinxlog" and return a list of phinxlog
    @GetMapping("/phinxlog")
    public List<Phinxlog> findAll(){
        return phinxlogService.findAll();
    }

    //add mapping for POST /phinxlog - add new phinxlog
    @PostMapping("/phinxlog")
    public Phinxlog addPhinxlog(@RequestBody Phinxlog thePhinxlog){
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        thePhinxlog.setStartTime(timestamp);
        thePhinxlog.setEndTime(null);
        Phinxlog newAgency = phinxlogService.save(thePhinxlog);
        return newAgency;
    }

    // add mapping for PUT /phinxlog - update existing phinxlog
    @PutMapping("/phinxlog")
    public Phinxlog updatePhinxlog(@RequestBody Phinxlog thePhinxlog){
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        thePhinxlog.setEndTime(timestamp);
        Phinxlog newAgency = phinxlogService.save(thePhinxlog);
        return newAgency;
    }

}
