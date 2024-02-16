package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Proposals;
import com.appxbuild.matrimony.service.ProposalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProposalsRestController {

    private ProposalsService proposalsService;

    @Autowired
    public ProposalsRestController(ProposalsService theProposalsService){
        proposalsService = theProposalsService;
    }

    // expose "/proposals" and return a list of UserProfiles
    @GetMapping("/proposals")
    public List<Proposals> findAll() {
        return proposalsService.findAll();
    }

    // add mapping for Get "/proposals/{proposalId}"
    @GetMapping("/proposals/{proposalId}")
    public Proposals getProposal(@PathVariable int proposalId){
        Proposals theProposal = proposalsService.findById(proposalId);

        if(theProposal == null){
            throw new RuntimeException("Proposal id is not found" + proposalId);
        }
        return theProposal;
    }

    // add mapping for POST "/proposals" - add new Proposal
    @PostMapping("/proposals")
    public Proposals addProposal(@RequestBody Proposals theProposals){
        theProposals.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theProposals.setCreated(localDateTime);
        theProposals.setModified(null);
        Proposals newProposal = proposalsService.save(theProposals);
        return newProposal;
    }

    // add mapping for PUT "/proposals" - update existing Proposal
    @PutMapping("/proposals")
    public Proposals updateProposal(@RequestBody Proposals theProposals){
        LocalDateTime localDateTime = LocalDateTime.now();
        theProposals.setModified(localDateTime);
        Proposals newProposal = proposalsService.save(theProposals);
        return newProposal;
    }

    // add mapping for DELETE "/proposals/{proposalId}" - delete Proposal
    @DeleteMapping("/proposals/{proposalId}")
    public String deleteProposal(@PathVariable int proposalId){
        Proposals theProposal = proposalsService.findById(proposalId);
        proposalsService.deleteById(proposalId);

        // throw exception if null
        if (theProposal == null){
            throw new RuntimeException("Proposal id is not found - " + proposalId);
        }
        return "Deleted Proposal id - " + proposalId;
    }

}

