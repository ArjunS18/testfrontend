package com.barclas.codefest.listeningear.referrals.web;

import com.barclas.codefest.listeningear.referrals.dto.ReferralDto;
import com.barclas.codefest.listeningear.referrals.model.Client;
import com.barclas.codefest.listeningear.referrals.model.Referral;
import com.barclas.codefest.listeningear.referrals.service.ClientService;
import com.barclas.codefest.listeningear.referrals.service.ReferralService;
import com.barclas.codefest.listeningear.referrals.dto.ReferralDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/referral")
public class ReferralController {
    @Autowired
    ReferralService referralService;
    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Referral> getAllReferrals() {
        try {
            return referralService.getAllReferrals();
        } catch (Exception ex) {
            return new ArrayList<Referral>();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Referral getReferralById(@PathVariable("id") Long id) throws Exception {
            return referralService.getReferralById(id);

    }

    @RequestMapping(value = "/approve/{id}", method = RequestMethod.PUT)
    public Referral approveReferral(@PathVariable("id") Long id) throws Exception {
           return referralService.approveReferral(id);

    }

    @RequestMapping(value = "/reject/{id}", method = RequestMethod.PUT)
    public Referral rejectReferral(@PathVariable("id") Long id) throws Exception {
        return referralService.rejectReferral(id);

    }

    @RequestMapping(value = "/clients/getAll", method = RequestMethod.GET)
    public List<Client> getAllClients() {
        try {
            return clientService.getAllClients();
        } catch (Exception ex) {
            return new ArrayList<Client>();
        }
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public Client getClientById(@PathVariable("id") Long id) throws Exception {
        return clientService.getClientById(id);

    }
}