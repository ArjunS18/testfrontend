package com.barclas.codefest.listeningear.referrals.service;

import com.barclas.codefest.listeningear.cases.model.CaseRepository;
import com.barclas.codefest.listeningear.cases.service.CaseService;
import com.barclas.codefest.listeningear.referrals.model.ReferralRepository;
import com.barclas.codefest.listeningear.cases.dto.Case;
import com.barclas.codefest.listeningear.referrals.model.Client;
//import com.barclas.codefest.listeningear.cases.model.Employee;
import com.barclas.codefest.listeningear.referrals.model.Referral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ReferralService {
    @Autowired
    ReferralRepository referralsRepository;
    @Autowired
    CaseService caseService;

    @Autowired
    ClientService clientService;

    public List<Referral> getAllReferrals() throws Exception {
        try {
            List<Referral> response = referralsRepository.findAll();
            return response;
        } catch (Exception e) {
            throw new Exception("Exception occurred while fetching all referrals!");
        }
    }

    @Transactional
    public Referral createReferral (String firstName, String surname, String dob,
                                  String address1, String address2, String phoneNo, String gpSurgeryName,
                                  String gpSurgeryAddress, String gpSurgeryPhoneNo) throws Exception {
        try {
            Referral referral = new Referral();
            referral.setFirstName(firstName);
            referral.setSurname(surname);
            referral.setDob(dob);
            referral.setAddress1(address1);
            referral.setAddress2(address2);
            referral.setPhoneNo(phoneNo);
            referral.setStatus("new");
            referral.setGpSurgeryName(gpSurgeryName);
            referral.setGpSurgeryAddress(gpSurgeryAddress);
            referral.setGpSurgeryPhoneNo(gpSurgeryPhoneNo);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            referral.setCreatedTime(timestamp);
            referral.setLastUpdated(timestamp);
            Client client = clientService.createClient(referral);
            referralsRepository.save(referral);
            return referral;
        } catch (Exception ex) {
            throw new Exception("Exception occurred in while creating Referral!" );
        }
    }

    public List<Referral> getNewReferrals() throws Exception {
        try {
            List<Referral> response = referralsRepository.findAllReferralsByStatus("new");
            return response;
        } catch (Exception e) {
            throw new Exception("Exception occurred while fetching new referrals!");
        }
    }

    public List<Referral> getApprovedReferrals() throws Exception {
        try {
            List<Referral> response = referralsRepository.findAllReferralsByStatus("approved");
            return response;
        } catch (Exception e) {
            throw new Exception("Exception occurred while fetching approved referrals!");
        }
    }

    public List<Referral> getRejectedReferrals() throws Exception {
        try {
            List<Referral> response = referralsRepository.findAllReferralsByStatus("rejected");
            return response;
        } catch (Exception e) {
            throw new Exception("Exception occurred while fetching rejected referrals!");
        }
    }

    @Transactional
    public Referral approveReferral(Long referralId) throws Exception {
        try {
            Referral refer = referralsRepository.findByReferralId(referralId);
            refer.setStatus("Accepted");
            Case cs = caseService.createCase(refer);

            refer.setCaseHistory(cs);

            referralsRepository.save(refer);

            //ClientService.(referral);
            return refer;

        } catch (Exception e) {
            throw new Exception("Exception occurred while approving referral!");
        }
    }

    @Transactional
    public Referral rejectReferral(Long referral) throws Exception {
        try {
            Referral refer = referralsRepository.findByReferralId(referral);
            refer.setStatus("Rejected");
            referralsRepository.save(refer);

            return refer;
        } catch (Exception e) {
            throw new Exception("Exception occurred while rejecting referral!");
        }
    }

    public Referral getReferralById(Long referralId) throws Exception {
        try {
            return referralsRepository.findByReferralId(referralId);

        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Exception occurred while fetching referral!");
        }
    }


}