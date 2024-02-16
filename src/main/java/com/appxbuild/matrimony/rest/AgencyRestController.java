package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Agencies;
import com.appxbuild.matrimony.entity.AgencyStatuses;
import com.appxbuild.matrimony.service.AgencyService;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AgencyRestController {

    private AgencyService agencyService;

    public AgencyRestController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    // "/agencies" -> return a list of agencies
    @GetMapping("/agencies")
    public List<Agencies> findAll() {
        System.out.println("\n\n------------------------> Error: "+agencyService.findAll()+"\n\n");
        return agencyService.findAll();
    }

    // "/agencies/{agencyId}" -> return agency with of specific id
    @GetMapping("/agencies/{agencyId}")
    public Agencies getAgency(@PathVariable int agencyId) {
        Agencies agencies = agencyService.findById(agencyId);

        if (agencies == null) {
            throw new RuntimeException("Agency id not found: " + agencyId);
        }
        System.out.println("\n\n------------------------> Error: "+agencies +"\n\n");
        return agencies;
    }

    // "/agencies" -> add new agency
    @PostMapping("/agencies")
    public Agencies addAgency(@RequestBody Agencies agencies) {

        agencies.setId(0);
        long millis = System.currentTimeMillis();
        Timestamp t = new Timestamp(millis);
        agencies.setCreated(t);
        agencies.setModified(null);

        Agencies dbAgency = agencyService.save(agencies);
        return dbAgency;
    }

    // "/agencies" -> update existing agency
    @PutMapping("/agencies")
    public Agencies updateAgency(@RequestBody Agencies agencies) {

        System.out.println("------------updating------------");
        long millis = System.currentTimeMillis();
        Timestamp t = new Timestamp(millis);
        agencies.setModified(t);
        System.out.println("\n\n----------------------->> " + agencyService.save(agencies) + " <<--------------------\n\n");

        Agencies dbAgency = agencyService.save(agencies);
        return dbAgency;
    }

    // "/agencies/{agencyId}" -> delete existing agency
    @DeleteMapping("/agencies/{agencyId}")
    public String delete(@PathVariable int agencyId) {

        Agencies dbAgency = agencyService.findById(agencyId);

        if (dbAgency == null) {
            throw new RuntimeException("Agency id not found: " + agencyId);
        }
        dbAgency.setAgencyStatuses(null);
        agencyService.delete(agencyId);
        return ("Agency id: " + agencyId + " deleted");
    }

}
