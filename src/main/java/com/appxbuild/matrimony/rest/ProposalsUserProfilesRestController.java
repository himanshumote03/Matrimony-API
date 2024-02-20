package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Proposals;
import com.appxbuild.matrimony.entity.ProposalsUserProfiles;
import com.appxbuild.matrimony.service.ProposalsUserProfilesService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProposalsUserProfilesRestController {
    private ProposalsUserProfilesService proposalsUserProfilesService;

    public ProposalsUserProfilesRestController(ProposalsUserProfilesService proposalsUserProfilesService) {
        this.proposalsUserProfilesService = proposalsUserProfilesService;
    }

    @GetMapping("/proposalsUserProfiles")
    public List<ProposalsUserProfiles> getProposalsUserProfiles () {
        return proposalsUserProfilesService.findAll();
    }

    // add mapping for Get "/proposalsUserProfiles/{proposalsUserProfilesId}"
    @GetMapping("/proposalsUserProfiles/{proposalsUserProfilesId}")
    public ProposalsUserProfiles getProposalsUserProfiles(@PathVariable int proposalsUserProfilesId){
        ProposalsUserProfiles theProposalsUserProfiles = proposalsUserProfilesService.findById(proposalsUserProfilesId);

        if(theProposalsUserProfiles == null){
            throw new RuntimeException("ProposalsUserProfiles id is not found" + proposalsUserProfilesId);
        }
        return theProposalsUserProfiles;
    }

    // add mapping for POST "/proposalsUserProfiles" - add new ProposalsUserProfiles
    @PostMapping("/proposalsUserProfiles")
    public ProposalsUserProfiles addProposalsUserProfiles(@RequestBody ProposalsUserProfiles theProposalsUserProfiles){
        theProposalsUserProfiles.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theProposalsUserProfiles.setCreated(localDateTime);
        theProposalsUserProfiles.setModified(null);
        ProposalsUserProfiles newProposalsUserProfiles = proposalsUserProfilesService.save(theProposalsUserProfiles);
        return newProposalsUserProfiles;
    }

    // add mapping for PUT "/proposalsUserProfiles" - update existing ProposalsUserProfiles
    @PutMapping("/proposalsUserProfiles")
    public ProposalsUserProfiles updateProposalsUserProfiles(@RequestBody ProposalsUserProfiles theProposalsUserProfiles){
        LocalDateTime localDateTime = LocalDateTime.now();
        theProposalsUserProfiles.setModified(localDateTime);
        ProposalsUserProfiles newProposalsUserProfiles = proposalsUserProfilesService.save(theProposalsUserProfiles);
        return newProposalsUserProfiles;
    }

    // add mapping for DELETE "/proposalsUserProfiles/{proposalsUserProfilesId}" - delete ProposalsUserProfiles
    @DeleteMapping("/proposalsUserProfiles/{proposalsUserProfilesId}")
    public String deleteProposalsUserProfiles(@PathVariable int proposalsUserProfilesId){
        ProposalsUserProfiles theProposalsUserProfiles = proposalsUserProfilesService.findById(proposalsUserProfilesId);
        proposalsUserProfilesService.deleteById(proposalsUserProfilesId);

        // throw exception if null
        if (theProposalsUserProfiles == null){
            throw new RuntimeException("ProposalsUserProfiles id is not found - " + proposalsUserProfilesId);
        }
        return "Deleted ProposalsUserProfiles id - " + proposalsUserProfilesId;
    }
}
