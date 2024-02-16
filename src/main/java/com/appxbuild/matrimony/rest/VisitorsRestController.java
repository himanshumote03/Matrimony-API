package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Visitors;
import com.appxbuild.matrimony.service.VisitorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class VisitorsRestController {

    private VisitorsService visitorsService;

    @Autowired
    public VisitorsRestController(VisitorsService theVisitorsService){
        visitorsService = theVisitorsService;
    }

    // expose "/visitors" and return a list of visitors
    @GetMapping("/visitors")
    public List<Visitors> findAll() {
        return visitorsService.findAll();
    }

    // add mapping for Get "/visitors/{visitorId}"
    @GetMapping("/visitors/{visitorId}")
    public Visitors getVisitor(@PathVariable int visitorId){
        Visitors theVisitor = visitorsService.findById(visitorId);

        if(theVisitor == null){
            throw new RuntimeException("Visitor is not found" + visitorId);
        }
        return theVisitor;
    }

    // add mapping for POST "/visitors" - add new visitor
    @PostMapping("/visitors")
    public Visitors addVisitor(@RequestBody Visitors theVisitors){
        theVisitors.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theVisitors.setCreated(localDateTime);
        theVisitors.setModified(null);
        Visitors newVisitor = visitorsService.save(theVisitors);
        return newVisitor;
    }

    // add mapping for PUT "/visitors" - update existing visitor
    @PutMapping("/visitors")
    public Visitors updateVisitor(@RequestBody Visitors theVisitors){
        LocalDateTime localDateTime = LocalDateTime.now();
        theVisitors.setModified(localDateTime);
        Visitors newVisitor = visitorsService.save(theVisitors);
        return newVisitor;
    }

    // add mapping for DELETE "/visitors/{visitorId}" - delete visitor
    @DeleteMapping("/visitors/{visitorId}")
    public String deleteVisitor(@PathVariable int visitorId){
        Visitors theVisitor = visitorsService.findById(visitorId);
        visitorsService.deleteById(visitorId);

        // throw exception if null
        if (theVisitor == null){
            throw new RuntimeException("Visitor id is not found - " + visitorId);
        }
        return "Deleted Visitor id - " + visitorId;
    }

}

