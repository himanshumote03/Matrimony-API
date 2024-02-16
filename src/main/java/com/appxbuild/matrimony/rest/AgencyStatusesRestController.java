package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.AgencyStatuses;
import com.appxbuild.matrimony.service.AgencyStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AgencyStatusesRestController {

    private AgencyStatusesService agencyStatusesService;

    @Autowired
    public AgencyStatusesRestController(AgencyStatusesService theAgencyStatusesService){
        agencyStatusesService = theAgencyStatusesService;
    }

    // expose "/agencyStatuses" and return a list of Agency Status
    @GetMapping("/agencyStatuses")
    public List<AgencyStatuses> findAll(){
        return agencyStatusesService.findAll();
    }

    // add mapping for Get "/agencyStatuses/{agencyStatusId}"
    @GetMapping("/agencyStatuses/{agencyStatusId}")
    public AgencyStatuses getAgencyStatuses(@PathVariable int agencyStatusId){
        AgencyStatuses theAgencyStatuses = agencyStatusesService.findById(agencyStatusId);

        if(theAgencyStatuses == null){
            throw new RuntimeException("Agency Status is not found" + agencyStatusId);
        }
        return theAgencyStatuses;
    }

    //add mapping for POST "/agencyStatuses" - add new Agency Status
    @PostMapping("/agencyStatuses")
    public AgencyStatuses addAgencyStatus(@RequestBody AgencyStatuses theAgencyStatuses){
        theAgencyStatuses.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theAgencyStatuses.setCreated(localDateTime);
        theAgencyStatuses.setModified(null);
        AgencyStatuses newAgencyStatus = agencyStatusesService.save(theAgencyStatuses);
        return newAgencyStatus;
    }

    // add mapping for PUT "/agencyStatuses" - update existing AgencyStatus
    @PutMapping("/agencyStatuses")
    public AgencyStatuses updateAgencyStatus(@RequestBody AgencyStatuses theAgencyStatuses){
        LocalDateTime localDateTime = LocalDateTime.now();
        theAgencyStatuses.setModified(localDateTime);
        AgencyStatuses newAgencyStatus = agencyStatusesService.save(theAgencyStatuses);
        return newAgencyStatus;
    }

    // add mapping for DELETE "/agencyStatuses/{agencyStatusId}" - delete AgencyStatus
    @DeleteMapping("/agencyStatuses/{agencyStatusId}")
    public String deleteAgencyStatus(@PathVariable int agencyStatusId){
        AgencyStatuses theAgencyStatus = agencyStatusesService.findById(agencyStatusId);
        agencyStatusesService.deleteById(agencyStatusId);

        // throw exception if null
        if (theAgencyStatus == null){
            throw new RuntimeException("Agency Status id is not found - " + agencyStatusId);
        }
        return "Deleted Agency Status id - " + agencyStatusId;
    }
}
