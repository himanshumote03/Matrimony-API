package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.ProposalsUserProfilesDAO;
import com.appxbuild.matrimony.entity.Degrees;
import com.appxbuild.matrimony.entity.ProposalsUserProfiles;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProposalsUserProfilesServiceImpl implements ProposalsUserProfilesService{

    private ProposalsUserProfilesDAO proposalsUserProfilesDAO;

    public ProposalsUserProfilesServiceImpl(ProposalsUserProfilesDAO proposalsUserProfilesDAO) {
        this.proposalsUserProfilesDAO = proposalsUserProfilesDAO;
    }

    @Override
    public List<ProposalsUserProfiles> findAll() {
        return proposalsUserProfilesDAO.findAll();
    }

    @Override
    public ProposalsUserProfiles findById(int theId) {
        Optional<ProposalsUserProfiles> result = proposalsUserProfilesDAO.findById(theId);
        ProposalsUserProfiles theProposalsUserProfiles = null;
        if(result.isPresent()){
            theProposalsUserProfiles = result.get();
        }
        else {
            throw new RuntimeException("Did not find degree id - " + theId);
        }
        return theProposalsUserProfiles;
    }

    @Override
    public ProposalsUserProfiles save(ProposalsUserProfiles theProposalsUserProfiles) {
        return proposalsUserProfilesDAO.save(theProposalsUserProfiles);
    }

    @Override
    public void deleteById(int theId) {
        proposalsUserProfilesDAO.deleteById(theId);
    }
}
