package com.barclas.codefest.listeningear.cases.service;

import com.barclas.codefest.listeningear.cases.model.CaseRepository;
import com.barclas.codefest.listeningear.referrals.model.ReferralRepository;
import com.barclas.codefest.listeningear.home.model.UserRepository;
import com.barclas.codefest.listeningear.cases.dto.Case;
import com.barclas.codefest.listeningear.cases.dto.Case;
import com.barclas.codefest.listeningear.cases.model.CaseRepository;
import com.barclas.codefest.listeningear.referrals.model.Client;
import com.barclas.codefest.listeningear.home.model.User;
import com.barclas.codefest.listeningear.referrals.model.Client;
import com.barclas.codefest.listeningear.referrals.model.Referral;
import com.barclas.codefest.listeningear.referrals.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class CaseService {
    @Autowired
    ReferralRepository referralsRepository;

    @Autowired
    CaseRepository caseRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    UserRepository userRepository;

    @Transactional
    public Case createCase(Referral referral) throws Exception {
        try {
            Case newCase = new Case();
            newCase.setFirstName(referral.getFirstName());
            newCase.setSurname(referral.getSurname());
            Client client = clientService.createClient(referral);
            newCase.setClient(client);
            newCase.setReferral(referral);
            newCase.setStatus("NEW");
            newCase.setCreationDate(new Timestamp(System.currentTimeMillis()));
            caseRepository.save(newCase);
            return newCase;

        } catch (Exception ex) {
            throw new Exception("Exception occurred in while creating Case!");
        }
    }


    @Transactional
    public Case assignDoctor(Long userId, Long caseId) throws Exception {
        try {
            Case assignedCase = caseRepository.findByCaseId(caseId);
            User user = userRepository.findByUserid(userId);
            assignedCase.setDoctor(user);
            caseRepository.save(assignedCase);

            return assignedCase;

        } catch (Exception e) {
            throw new Exception("Exception occurred while assigning doctor to the case!");
        }
    }

    @Transactional
    public List<Case> getCasesOfClient(Long clientId) throws Exception {
        try {
            return caseRepository.findAllCasesByClientId(clientId);

        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Exception occurred while fetching cases of client!");
        }
    }

    public List<Case> getAllCases() throws Exception {
        try {
            List<Case> response = caseRepository.findAll();
            return response;
        } catch (Exception e) {
            throw new Exception("Exception occurred while fetching all referrals!");
        }
    }


}

