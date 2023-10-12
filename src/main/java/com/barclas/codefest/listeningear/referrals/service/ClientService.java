package com.barclas.codefest.listeningear.referrals.service;

import com.barclas.codefest.listeningear.cases.model.CaseRepository;
import com.barclas.codefest.listeningear.referrals.model.ReferralRepository;
import com.barclas.codefest.listeningear.referrals.model.ClientRepository;
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
public class ClientService {
    @Autowired
    ReferralRepository referralsRepository;

    @Autowired
    ClientRepository clientRepository;


    @Transactional
    public Client createClient (Referral referral) throws Exception {
        try {
            Client newClient = new Client();
            String clientId = referral.getFirstName() + "_" + referral.getSurname() + "_" + referral.getDob();
            if (clientRepository.countByClientId(clientId) == 0) {
                //newClient.setClientId(clientId);
                newClient.setFirstName(referral.getFirstName());
                newClient.setSurname(referral.getSurname());
                newClient.setDob(referral.getDob());
                newClient.setAddress1(referral.getAddress1());
                newClient.setAddress2(referral.getAddress2());
                newClient.setPhoneNo(referral.getPhoneNo());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                newClient.setCreatedOn(timestamp);
                newClient.setLastUpdated(timestamp);
                newClient.setAlternateName(referral.getFirstName() + "_" + referral.getSurname() + "_" + referral.getDob());
                clientRepository.save(newClient);

                return newClient;
            }
            else {
                throw new Exception("Referral for client already exists!");
            }
        } catch (Exception ex) {
            throw new Exception("Exception occurred in while creating Referral!");
        }
    }

    public List<Client> getAllClients() throws Exception {
        try {
            List<Client> response = clientRepository.findAll();
            return response;

        } catch (Exception e) {
            throw new Exception("Exception occurred while fetching all referrals!");
        }
    }

    public Client getClientById(Long clientId) throws Exception {
        try {
            return clientRepository.findByClientId(clientId);

        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Exception occurred while fetching Client!");
        }
    }


}
