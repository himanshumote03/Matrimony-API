package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.ProposalsDAO;
import com.appxbuild.matrimony.entity.Proposals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProposalsServiceImpl implements ProposalsService {

    private ProposalsDAO proposalsDAO;

    @Autowired
    public ProposalsServiceImpl(ProposalsDAO theProposalsDAO){
        proposalsDAO = theProposalsDAO;
    }

    @Override
    public List<Proposals> findAll() {
        return proposalsDAO.findAll();
    }

    @Override
    public Proposals findById(int theId) {
        Optional<Proposals> result = proposalsDAO.findById(theId);
        Proposals theProposal = null;
        if(result.isPresent()){
            theProposal = result.get();
        }
        else {
            throw new RuntimeException("Proposal id is not found " + theId);
        }
        return theProposal;
    }


    @Override
    public Proposals save(Proposals theProposals) {
        return proposalsDAO.save(theProposals);
    }

    @Override
    public void deleteById(int theId) {
        proposalsDAO.deleteById(theId);
    }

}
