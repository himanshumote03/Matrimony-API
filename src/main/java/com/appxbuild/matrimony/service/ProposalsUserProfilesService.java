package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Degrees;
import com.appxbuild.matrimony.entity.ProposalsUserProfiles;

import java.util.List;

public interface ProposalsUserProfilesService {
    List<ProposalsUserProfiles> findAll();

    ProposalsUserProfiles findById(int theId);

    ProposalsUserProfiles save(ProposalsUserProfiles theProposalsUserProfiles);

    void deleteById(int theId);
}
