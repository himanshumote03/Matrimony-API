package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Proposals;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProposalsService {

    List<Proposals> findAll();
    Proposals findById(int theId);
    Proposals save(Proposals theProposals);
    void deleteById(int theId);

}
